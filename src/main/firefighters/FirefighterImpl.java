package main.firefighters;

import main.api.CityNode;
import main.api.Firefighter;

public class FirefighterImpl implements Firefighter {

  private CityNode location;
  private int distanceTraveled;

  public FirefighterImpl() {}

  public FirefighterImpl(CityNode homeBase) {
    this.location = homeBase;
    this.distanceTraveled = 0;
  }

  @Override
  public CityNode getLocation() {
    return location;
  }

  @Override
  public void setLocation(CityNode newLocation) {
    this.location = newLocation;
  }

  @Override
  public int distanceTraveled() {
    return distanceTraveled;
  }

  @Override
  public void updateDistanceTraveled(int distance) {
    distanceTraveled += distance;
  }
}
