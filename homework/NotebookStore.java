package homework;

import java.util.*;

public class NotebookStore {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Dell", 8, 512, "Windows", "Black"));
        notebooks.add(new Notebook("HP", 16, 256, "Windows", "Silver"));
        notebooks.add(new Notebook("HP", 16, 256, "Windows", "Silver"));
        notebooks.add(new Notebook("Apple", 16, 1000, "macOS", "Gray"));
        notebooks.add(new Notebook("Lenovo", 4, 128, "Linux", "Black"));

        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ (4/8/16 ГБ)");
        System.out.println("2 - Объем ЖД (128/256/512/1000 ГБ)");
        System.out.println("3 - Операционная система (Windows/macOS/Linux)");
        System.out.println("4 - Цвет (Black/Silver/Grey");

        while (true) {
            int criterion = scanner.nextInt();
            scanner.nextLine();
            if (criterion < 1 || criterion > 4) {
                System.out.println("Некорректный ввод. Попробуйте снова.");
                continue;
            }

            String value;
            if (criterion == 3 || criterion == 4) {
                System.out.println("Введите значение: ");
                value = scanner.nextLine();
            } else {
                System.out.print("Введите минимальное значение: ");
                value = scanner.nextLine();
            }
            filters.put(criterion, value);

            System.out.print("Хотите добавить еще критерий? (да/нет): ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("нет")) {
                break;
            }
        }

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);
        System.out.println("Ноутбуки, соответствующие вашим критериям:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<Integer, String> filters) {
        Set<Notebook> filtered = new HashSet<>(notebooks);

        for (Map.Entry<Integer, String> entry : filters.entrySet()) {
            int criterion = entry.getKey();
            String value = entry.getValue();

            filtered.removeIf(notebook -> {
                switch (criterion) {
                    case 1:
                        return notebook.getRam() < Integer.parseInt(value);
                    case 2:
                        return notebook.getStorage() < Integer.parseInt(value);
                    case 3:
                        return !notebook.getOs().equalsIgnoreCase(value);
                    case 4:
                        return !notebook.getColor().equalsIgnoreCase(value);
                    default:
                        return false;
                }
            });
        }
        return filtered;
    }
}
