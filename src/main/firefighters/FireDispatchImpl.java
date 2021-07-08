package main.firefighters;

import java.util.ArrayList;
import java.util.List;

import main.api.City;
import main.api.CityNode;
import main.api.FireDispatch;
import main.api.Firefighter;
import main.api.exceptions.NoFireFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FireDispatchImpl implements FireDispatch {

  private City city;
  private List<Firefighter> firefighterList;

  public FireDispatchImpl(City city) {
    this.city = city;
    this.firefighterList = new ArrayList<Firefighter>();
  }

  @Override
  public void setFirefighters(int numFirefighters) {
    for (int i = 0; i < numFirefighters; i++) {
      firefighterList.add(new FirefighterImpl(city.getFireStation().getLocation()));
    }
  }

  @Override
  public List<Firefighter> getFirefighters() {
    return firefighterList;
  }

  @Override
  public void dispatchFirefighers(CityNode... burningBuildings) {
    for (CityNode coordinates: burningBuildings) {
      Firefighter assignee = new FirefighterImpl();
      int distance = -1;
      for (Firefighter firefighter : firefighterList) {
        int ffDistanceX = Math.abs(firefighter.getLocation().getX() - coordinates.getX());
        int ffDistanceY = Math.abs(firefighter.getLocation().getY() - coordinates.getY());
        int ffTotalDistance = ffDistanceX + ffDistanceY;
        if (distance == -1 || ffTotalDistance < distance) {
          distance = ffTotalDistance;
          assignee = firefighter;
        }
      }
      assignee.setLocation(coordinates);
      assignee.updateDistanceTraveled(distance);

      try {
        city.getBuilding(coordinates).extinguishFire();
      } catch (NoFireFoundException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
