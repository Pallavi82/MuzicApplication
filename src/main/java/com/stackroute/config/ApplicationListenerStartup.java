package com.stackroute.config;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackServiceImplementation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:application.properties")
public class ApplicationListenerStartup implements ApplicationListener<ContextRefreshedEvent> {
     private static final Logger logs=Logger.getLogger(ApplicationListenerStartup.class);

    private TrackRepository trackRepository;



    @Autowired
    private Environment env;

    @Autowired
    public ApplicationListenerStartup(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){

            logs.info("data inserted");

            Track track2 = new Track(2,"Perfect","Singer : Ed Sheeran");
            trackRepository.save(track2);
            Track track4 = new Track(4,"Let it go","Singer : Demi Lovato");
            trackRepository.save(track4);
            Track track6 = new Track(6,"Love Story","Singer : Taylor Swift");
            trackRepository.save(track6);
            Track track8 = new Track(8,"Thousand Years","Singer : Christina Perri");
            trackRepository.save(track8);
            Track track9 = new Track(Integer.parseInt(env.getProperty("app.trackID")),env.getProperty("app.trackname"),env.getProperty("app.comments"));
            trackRepository.save(track9);


        }
    }
