package ses.proj.entity;

import java.util.ArrayList;
import java.util.List;

public class DefaultAlerts {

	private static List<AlertType> alertList;

	static {
		alertList = new ArrayList<>(4);
		alertList.add(new AlertType(1L, "Biodegradable bin is full !!"));
		alertList.add(new AlertType(2L, "Non-Biodegradable bin is full !!"));
		alertList.add(new AlertType(3L, "Biodegradable bin lock malfunction !!"));
		alertList.add(new AlertType(4L, "Non-Biodegradable lock malfunction !!"));
	}

	private DefaultAlerts() {

	}

	public static List<AlertType> getDefaultAlerts() {
		return new ArrayList<AlertType>(alertList);
	}

}
