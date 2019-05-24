package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/track")
    public ResponseEntity<Track> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            Track track1 = trackService.saveTrack(track);
            responseEntity = new ResponseEntity<Track>(track1, HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;

    }
    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getAllTracks() {
        List<Track> track1 = trackService.getAllTracks();
        return new ResponseEntity<List<Track>>(track1, HttpStatus.OK);
    }


    @PutMapping("/track" )
    public ResponseEntity<Track> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        try {
            Track track1 = trackService.updateComment(track);
            return new ResponseEntity<Track>(track1, HttpStatus.OK);
        }catch (TrackNotFoundException ex)
        {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
            throw ex;
        }
//        return responseEntity;

    }


    @DeleteMapping("/track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable int id){

        ResponseEntity responseEntity;
        try{
          trackService.deleteTrack(id);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);

        } catch (TrackNotFoundException ex)
        {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @RequestMapping(value ="track/{trackName}", method = RequestMethod.GET)
    public ResponseEntity<List<Track>>getTrackByName(@PathVariable("trackName") String trackName) throws TrackNotFoundException {
        List<Track> trackOne = trackService.getTrackByName(trackName);
        return new ResponseEntity<List<Track>>(trackOne, HttpStatus.OK);
    }
}
