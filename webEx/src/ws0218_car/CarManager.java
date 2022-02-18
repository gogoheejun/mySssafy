package ws0218_car;

import java.util.List;

public interface CarManager {
	void add(Car car) throws SameNumberException;
	
	List<Car> search();
	
	Car SearchByNumber(int number) throws NotFoundException;
	
	void save();
	
	List<Car> load();
}
