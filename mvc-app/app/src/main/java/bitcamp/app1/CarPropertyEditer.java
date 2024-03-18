package bitcamp.app1;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.sql.Date;
import org.checkerframework.checker.units.qual.C;

public class CarPropertyEditer extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] values = text.split(","); // medel,maker,capacity,createdDate
    Car car = new Car();
    car.setModel(values[0]);
    car.setMaker(values[1]);
    car.setCapacity(Integer.parseInt(values[2]));
    car.setAuto(Boolean.parseBoolean(values[3]));
    car.setCreatedDate(Date.valueOf(values[4]));

    this.setValue(car);
  }
}
