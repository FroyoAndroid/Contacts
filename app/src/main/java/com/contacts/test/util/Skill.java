package com.contacts.test.util;

import com.orm.SugarRecord;

/**
 * Created by nirajkumar.chauhan on 12/22/2014.
 */
public class Skill extends SugarRecord<Skill>{
    int cockpitDrill,movingAway,stopping,turningLeft,turningRight,tJunction,crossroads,
    roundabouts,pedestarianCrossing,dualCarriageways,oneWayStreets,meetingSituations,defensiveDriving,
    usingMirrors,emergencyStop,ecoDriving,turnInTheRoad,parallelParking,leftReverse,bayParking,showAndTell,mockTests;

    public int getCockpitDrill() {
        return cockpitDrill;
    }

    public void setCockpitDrill(int cockpitDrill) {
        this.cockpitDrill = cockpitDrill;
    }

    public int getMovingAway() {
        return movingAway;
    }

    public void setMovingAway(int movingAway) {
        this.movingAway = movingAway;
    }

    public int getStopping() {
        return stopping;
    }

    public void setStopping(int stopping) {
        this.stopping = stopping;
    }

    public int getTurningLeft() {
        return turningLeft;
    }

    public void setTurningLeft(int turningLeft) {
        this.turningLeft = turningLeft;
    }

    public int getTurningRight() {
        return turningRight;
    }

    public void setTurningRight(int turningRight) {
        this.turningRight = turningRight;
    }

    public int gettJunction() {
        return tJunction;
    }

    public void settJunction(int tJunction) {
        this.tJunction = tJunction;
    }

    public int getCrossroads() {
        return crossroads;
    }

    public void setCrossroads(int crossroads) {
        this.crossroads = crossroads;
    }

    public int getRoundabouts() {
        return roundabouts;
    }

    public void setRoundabouts(int roundabouts) {
        this.roundabouts = roundabouts;
    }

    public int getPedestarianCrossing() {
        return pedestarianCrossing;
    }

    public void setPedestarianCrossing(int pedestarianCrossing) {
        this.pedestarianCrossing = pedestarianCrossing;
    }

    public int getDualCarriageways() {
        return dualCarriageways;
    }

    public void setDualCarriageways(int dualCarriageways) {
        this.dualCarriageways = dualCarriageways;
    }

    public int getOneWayStreets() {
        return oneWayStreets;
    }

    public void setOneWayStreets(int oneWayStreets) {
        this.oneWayStreets = oneWayStreets;
    }

    public int getMeetingSituations() {
        return meetingSituations;
    }

    public void setMeetingSituations(int meetingSituations) {
        this.meetingSituations = meetingSituations;
    }

    public int getDefensiveDriving() {
        return defensiveDriving;
    }

    public void setDefensiveDriving(int defensiveDriving) {
        this.defensiveDriving = defensiveDriving;
    }

    public int getUsingMirrors() {
        return usingMirrors;
    }

    public void setUsingMirrors(int usingMirrors) {
        this.usingMirrors = usingMirrors;
    }

    public int getEmergencyStop() {
        return emergencyStop;
    }

    public void setEmergencyStop(int emergencyStop) {
        this.emergencyStop = emergencyStop;
    }

    public int getEcoDriving() {
        return ecoDriving;
    }

    public void setEcoDriving(int ecoDriving) {
        this.ecoDriving = ecoDriving;
    }

    public int getTurnInTheRoad() {
        return turnInTheRoad;
    }

    public void setTurnInTheRoad(int turnInTheRoad) {
        this.turnInTheRoad = turnInTheRoad;
    }

    public int getParallelParking() {
        return parallelParking;
    }

    public void setParallelParking(int parallelParking) {
        this.parallelParking = parallelParking;
    }

    public int getLeftReverse() {
        return leftReverse;
    }

    public void setLeftReverse(int leftReverse) {
        this.leftReverse = leftReverse;
    }

    public int getBayParking() {
        return bayParking;
    }

    public void setBayParking(int bayParking) {
        this.bayParking = bayParking;
    }

    public int getShowAndTell() {
        return showAndTell;
    }

    public void setShowAndTell(int showAndTell) {
        this.showAndTell = showAndTell;
    }

    public int getMockTests() {
        return mockTests;
    }

    public void setMockTests(int mockTests) {
        this.mockTests = mockTests;
    }

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

    public Skill() {
    }
}
