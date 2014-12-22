package com.contacts.test.util;

import com.orm.SugarRecord;

/**
 * Created by nirajkumar.chauhan on 12/22/2014.
 */
public class Skill extends SugarRecord<Skill>{
    int cockpitDrill,movingAway,stopping,turningLeft,turningRight,tJunction,crossroads,
    roundabouts,pedestarianCrossing,dualCarriageways,oneWayStreets,meetingSituations,defensiveDriving,
    usingMirrors,emergencyStop,ecoDriving,turnInTheRoad,parallelParking,leftReverse,bayParking,showAndTell,mockTests;

    public Skill(int cockpitDrill, int movingAway, int stopping, int turningLeft, int turningRight, int tJunction, int crossroads, int roundabouts, int pedestarianCrossing, int dualCarriageways, int oneWayStreets, int meetingSituations, int defensiveDriving, int usingMirrors, int emergencyStop, int ecoDriving, int turnInTheRoad, int parallelParking, int leftReverse, int bayParking, int showAndTell, int mockTests) {
        this.cockpitDrill = cockpitDrill;
        this.movingAway = movingAway;
        this.stopping = stopping;
        this.turningLeft = turningLeft;
        this.turningRight = turningRight;
        this.tJunction = tJunction;
        this.crossroads = crossroads;
        this.roundabouts = roundabouts;
        this.pedestarianCrossing = pedestarianCrossing;
        this.dualCarriageways = dualCarriageways;
        this.oneWayStreets = oneWayStreets;
        this.meetingSituations = meetingSituations;
        this.defensiveDriving = defensiveDriving;
        this.usingMirrors = usingMirrors;
        this.emergencyStop = emergencyStop;
        this.ecoDriving = ecoDriving;
        this.turnInTheRoad = turnInTheRoad;
        this.parallelParking = parallelParking;
        this.leftReverse = leftReverse;
        this.bayParking = bayParking;
        this.showAndTell = showAndTell;
        this.mockTests = mockTests;
    }
}
