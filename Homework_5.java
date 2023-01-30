/*  
1. Создать словарь HashMap. Обобщение <Integer, String>.
2. Заполнить пятью ключами (индекс, ФИО + Возраст + Пол "Иванов Иван Иванович 28 м"), добавить ключь, если не было!)
3. Изменить значения сделав пол большой буквой.
4. Пройти по коллекции и вывести значения в формате Фамилия инициалы: "Иванов И.И."
5. *Сортировать значения по возрасту и вывести отсортированную коллекцию как в четвёртом пункте.
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework_5 {
	public static void main(String[] args) {
		HashMap<Integer, String> dictPeople = new HashMap<Integer, String>();

		dictPeople.put(1, "Иванов Петр Сергеевич 25 м");
		dictPeople.put(2, "Петров Иван Сидорович 27 м");
		dictPeople.put(3, "Сидорова Елена Николаевна 44 ж");
		dictPeople.put(4, "Мягков Михаил Петрович 36 м");
		dictPeople.put(5, "Кошкина Светлана Сергеевна 23 ж");

		if (!dictPeople.containsKey(6)) {
			dictPeople.put(6, "Пешков Семен Андреевич 33 м");
		}

		/*  Создание нового списка, содержащий все записи dictPeople, и сортировка по возрасту человека. */
		List<Map.Entry<Integer, String>> list = new ArrayList<>(dictPeople.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {

		// Сортировка по возрасту в порядке возрастания
		public int compare(Map.Entry<Integer, String> entry1, Map.Entry<Integer, String> entry2) {
			return Integer.compare(Integer.parseInt(entry1.getValue().split(" ")[3]),
				   Integer.parseInt(entry2.getValue().split(" ")[3]));
			}
		});

		System.out.println("\nСортировка в порядке возрастания: \n");
		int counter = 1;
		for (Map.Entry<Integer, String> entry : list) {
			String[] parts = entry.getValue().split(" ");
			String surname = parts[0];
			String initials = parts[1].charAt(0) + "." + parts[2].charAt(0) + ".";
			String age = parts[3];
			String gender = parts[4];
			System.out.println(counter + ". " + surname + " " + initials + " " + age + " " + gender.toUpperCase());
			counter++;
		}
	}

}