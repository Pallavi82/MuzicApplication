package com.stackroute.config;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;

import com.stackroute.service.TrackServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerStartup implements CommandLineRunner {

    @Value("${app.trackID}")
    private int trackID;
    @Value("${app.trackname}")
    private String trackName;
    @Value("${app.comments}")
    private String comments;

    Track track = new Track();

    @Autowired
    public CommandLineRunnerStartup(TrackServiceImplementation trackServiceImplementation) {
        this.trackServiceImplementation = trackServiceImplementation;
    }

    TrackServiceImplementation trackServiceImplementation;
//
//    public static final Logger logs = LoggerFactory.getLogger(CommandLineRunnerStartup.class);
//    private TrackRepository trackRepository;

//    @Autowired
//    public CommandLineRunnerStartup(TrackRepository trackRepository){
//        this.trackRepository=trackRepository;
//    }

    @Override
    public void run(String... args) throws Exception{

//        logs.info("Inserting data on start");

        track.setTrackID(trackID);
        track.setTrackName(trackName);
        track.setComments(comments);
        trackServiceImplementation.seedData(track);

//        Track track1 = new Track(1,"Baby","Singer : Justin Bieber");
//        trackRepository.save(track1);
//        Track track3 = new Track(3,"I wanna grow old with you","Artist : Westlife");
//        trackRepository.save(track3);
//        Track track5 = new Track(5,"What makes you beautiful","Artist : One Direction");
//        trackRepository.save(track5);
//        Track track7 = new Track(7,"Shallow","Singer : Lady Gaga");
//        trackRepository.save(track7);
    }
}