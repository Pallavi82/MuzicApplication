package com.stackroute.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    @Id
    private int trackID;
    private String trackName;
    private String comments;

//    public int getTrackID() {
//        return trackID;
//    }
//
//    public void setTrackID(int trackID) {
//        this.trackID = trackID;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
}