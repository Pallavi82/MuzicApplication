package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImplementation implements TrackService {

    Track track;

    @Autowired
    private TrackRepository trackRepository;
    private TrackServiceImplementation trackServiceImplementation;

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    public TrackServiceImplementation() {
    }

    public TrackServiceImplementation(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackID()))
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track track1 = trackRepository.save(track);

        if (track1==null)
        {
            throw new TrackAlreadyExistsException("Track already saved");
        }
        return track1;
    }

    @Override
    public List<Track> getAllTracks() {
        List <Track> track1 = (List<Track>) trackRepository.findAll();
        return track1;
    }

    @Override
    public Track updateComment(Track track) throws TrackNotFoundException {
        if (trackRepository.existsById(track.getTrackID()))
        {
            Track track1 = trackRepository.findById(track.getTrackID()).get();
            track1.setComments(track.getComments());
            trackRepository.save(track1);
            return track1;
        }
        else
        {
            throw new TrackNotFoundException("Track not found exception");
        }
    }
    @Override
    public void deleteTrack(int id) throws TrackNotFoundException {

        track = trackRepository.getOne(id);
        if (trackRepository.existsById(track.getTrackID()))
        {
            trackRepository.deleteById(id);
            //return null;
        }
        else
        {
            throw new TrackNotFoundException("Track not found exception");
        }
    }

    @Override
    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException{

        List<Track> listOfTracks = null;
        listOfTracks = trackRepository.getTrackByName(trackName);
        if (listOfTracks.equals(null))
        {
            throw new TrackNotFoundException("Track not found exception");
        }
        return listOfTracks;
    }

    public void seedData(Track track){
        trackRepository.save(track);
    }
}