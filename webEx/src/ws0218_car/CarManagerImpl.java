package ws0218_car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarManagerImpl implements CarManager {

//	private static CarManager instance = new CarManagerImpl();//이렇게 하는것도 싱글톤임.
//	public static CarManager getInstance() {
//		
//		return instance;
//	}

	private List<Car> list;
	private Map<Integer, Integer> map;

	public CarManagerImpl() {
		list = new ArrayList<Car>();
		map = new HashMap<Integer, Integer>();
	}

	// 싱글톤
	private static CarManager instance;

	public static CarManager getInstance() {
		if (instance == null) {
			instance = new CarManagerImpl();
		}
		return instance;
	}

	@Override
	public void add(Car car) throws SameNumberException {
		check(car.getCarNum());// 이건 내가 한거임ㅎ

		list.add(car);
	}

	public void check(int number) throws SameNumberException {
		if (map.getOrDefault(number, 0) > 0) {
			throw new SameNumberException("SameNumberException 발생: " + number + "은 중복됩니다.");
		} else {
			map.put(number, 1);
		}
	}

	// ----------------------
	@Override
	public List<Car> search() {
		return list;
	}

	// ------------------

	@Override
	public Car SearchByNumber(int number) throws NotFoundException {
		for (Car car : list) {
			if (car.getCarNum() == number)
				return car;
		}

		throw new NotFoundException("NotFoundException 발생: " + number + "은 미등록 차량!!");
	}

	// ----------------

	//cat.txt로 저장
	@Override
	public void save() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("car.txt"));
			out.writeObject(list);
			out.flush(); //내보내고 버퍼 지우기
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {}
		}
	}
	
	//----------------
	//car.txt를 읽기
//	@Override
	public List<Car> load2() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("car.txt"));
			Object obj = in.readObject();
			if(obj instanceof List) {
				return (List<Car>)obj;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return null;
	}
	
	@Override
	public List<Car> load() {
		File f = new File("car.txt");
		
		if(f.exists()) {
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(new FileInputStream(f));
				list = (List<Car>)in.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					in.close();
				} catch (IOException e) {}
			}
			return list;
		}else {
			return Collections.EMPTY_LIST;
		}
		
	}
}
