package bootcamp;
import java.util.*;;

public class Lists {
	static List<Integer> numbers = new ArrayList<>();
	static String numberOfInputs = "Enter the size of the list: ";
	static String numberOfInputsFinal = "Your number of Inputs: ";
	static String tryAgainMessage = "Try Again";
	static String enterInput = "Enter your input: ";
	static String enterX = "Enter index: ";
	static String enterQueries = "Enter the number of Queries: ";
	static String enterOption = "Type Insert or Delete to continue: ";
	static String warning = "Input must not be greater than List size: ";
	static String error = "Error!";

	public static void main(String[] args) {
		numberOfRows();
	}

	public static void numberOfRows() {
		System.out.println(numberOfInputs);
		int finalNumberOfRows;
		do {
			finalNumberOfRows = isNumber();
		} while (finalNumberOfRows <= 0 && finalNumberOfRows >= 4000);
		System.out.println(numberOfInputsFinal + finalNumberOfRows);
		fillList(finalNumberOfRows);
	}

	public static void fillList(int inputs) {
		for (int i = 1; i <= inputs; i++) { // column
			System.out.println(enterInput + (i));
			int number = isNumber();
			numbers.add(number);
		}
		System.out.println(numbers);
		enterCoordenates();
	}

	public static void enterCoordenates() {
		System.out.println(enterQueries);
		int queries;
		do {
			queries = isNumber();
		} while (queries <= 0 && queries >= 4000);
		for (int i = 0; i < queries; i++) {
			boolean addToList = chooseOption();
			if (addToList) {
				goingToAdd();
			} else {
				goingToDelete();
			}
		}
	}

	private static void goingToDelete() {
		System.out.println(enterX);
		int index;
		do {
			System.out.println(warning);
			index = isNumber();
		} while (index > numbers.size());
		numbers.remove(index);
		System.out.println(numbers);
	}

	private static void goingToAdd() {
		System.out.println(enterX);
		int index;
		do {
			System.out.println(warning);
			index = isNumber();
		} while (index > numbers.size());
		System.out.println(enterInput);
		int number = isNumber();
		numbers.add(index, number);
		System.out.println(numbers);

	}

	static int isNumber() {
		do {
			Scanner scanner = new Scanner(System.in);
			boolean nextStep;
			try {
				String number = scanner.next();
				Integer.parseInt(number);
				nextStep = true;
				return Integer.parseInt(number);
			} catch (Exception e) {
				System.out.println(tryAgainMessage);
			}
		} while (!false);
	}

	static boolean chooseOption() {
		do {
			System.out.println(enterOption);
			Scanner scanner = new Scanner(System.in);
			boolean nextStep = false;
			try {
				String option;
				option = scanner.next().toLowerCase();
				if (option.contentEquals("insert")) {
					nextStep = true;
					return true;
				} else if (option.contentEquals("delete")) {
					nextStep = true;
					return false;
				}
			} catch (Exception e) {
				System.out.println(tryAgainMessage);
			}
		} while (!false);
	}
}
