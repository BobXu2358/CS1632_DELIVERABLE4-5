import java.util.LinkedList;
import java.util.List;

public class MonkeySim {

  private static List<Monkey> monkeyList = new LinkedList<Monkey>();

  /**
   * Print out use message and exit with
   * error code 1.
   */

  public static void errorAndExit() {
    System.out.println("USAGE:");
    System.out.println("java MonkeySim <num_monkeys>");
    System.out.println("<num_monkeys> must be a positive signed 32-bit integer");
    System.exit(1);
  }

  /**
   * Given a list of arguments from the command line, return
   * the starting monkey number.
   * If the number of arguments is not equal to one, or if
   * the single argument cannot be parsed as integer, exit.
   * @param args - array of args from command line
   * @return int - starting monkey
   */

  public static int getStartingMonkeyNum(String[] args) {
    int startingMonkeyNum = 0;
    if (args.length != 1) {
        errorAndExit();
    }
    try {
        startingMonkeyNum = Integer.parseInt(args[0]);
    } catch (NumberFormatException exception) {
        errorAndExit();
    }
    if (startingMonkeyNum < 1) {
        errorAndExit();
    }
    return startingMonkeyNum;
  }

  /**
   * Get a reference to the first monkey in the list.
   * @return Monkey first monkey in list
   */

  public static Monkey getFirstMonkey(List<Monkey> ml) {
    for (int j = 0; j < ml.size(); j++) {
      if (ml.get(j).getMonkeyNum() == 1) {
        return ml.get(j);
      }
    }
    return null;
  }

  /**
   * Return a String version of a round.
   * @param count Round number
   * @param m1 Monkey thrown from
   * @param m2 Monkey thrown to
   * @return String string version of round
   */

  public static String stringifyResults(int count, Monkey m1, Monkey m2) {
    String toReturn = null;
    try {
      toReturn = "//Round " + count + ": Threw banana from Monkey (#" + m1.getMonkeyNum()
      + " / ID " + m1.getId() + ") to Monkey (#" + m2.getMonkeyNum() + " / ID " + m2.getId() + ")";
    } catch (NoIdException noindex) {
        System.out.println("INVALID MONKEY!");
    }
    return toReturn;
  }

  /**
   * Return the number of the monkey with a banana.
   * @param ml list of monkeys
   * @return int number of monkey w/ banana
   */

  public static int monkeyWithBanana(List<Monkey> ml) {
    for (int j = 0; j < ml.size(); j++) {
      Monkey monkey = ml.get(j);
      if (monkey.hasBanana()) {
        return monkey.getMonkeyNum();
      }
    }
    return -1;
  }

  /**
   * Add more monkeys to the list so that the size is n.
   * @param num new desired size of list
   * @param ml list of monkeys
   * @return int number of monkey w/ banana
   */

  public static int addMoreMonkeys(int num, List<Monkey> ml) {
    while (ml.size() <= num) {
      ml.add(new Monkey(ml.size()));
    }
    return ml.size();
  }

  /**
   * Find number of next monkey and resize list if necessary.
   * @param monkey initial monkey
   * @param ml list of monkeys
   * @param time specifies which simulation it is to choose which algorithm to use
   * @return int number of monkey w/ banana
   */

  public static int nextMonkeyAndResize(Monkey monkey, List<Monkey> ml, int time) {
    int num;
    if (time == 1) {
      num = monkey.nextMonkey();
    } else {
      num = monkey.nextMonkeySecond();
    }
    if (num > ml.size()) {
      addMoreMonkeys(num, ml);
    }
    return num;
  }

  /**
   * Run the simulation.
   * @param ml List of Monkeys
   * @param mw watcher of monkey
   * @return int number of rounds taken to get to first monkey
   */

  public static int runSimulation(List<Monkey> ml, MonkeyWatcher mw, int time) {
    int nextMonkey = -1;
    while (!getFirstMonkey(ml).hasBanana()) {
      mw.incrementRounds();
      Monkey m1 = ml.get(monkeyWithBanana(ml));
      int num = nextMonkeyAndResize(m1, ml, time);
      Monkey m2 = ml.get(num);
      Banana ban = m1.throwBananaFrom();
      m2.throwBananaTo(ban);
      String string = stringifyResults(mw.getRounds(), m1, m2);
      System.out.println(string);
    }
    System.out.println("First monkey has the banana!");
    return mw.getRounds();
  }

  /**
   * Entry point of program - run MonkeySim.
   * Accepts one argument, the starting monkey
   * number.
   * @param args - Array of arguments from cmd line
   */

  public static void main(String[] args) {
    int startNum = getStartingMonkeyNum(args);
    Monkey tmpMonkey;
    Banana banana = new Banana();
    MonkeyWatcher mw = new MonkeyWatcher();

    for (int j = 0; j < startNum + 1; j++) {
      tmpMonkey = new Monkey(monkeyList.size());
      monkeyList.add(tmpMonkey);
    }

    monkeyList.get(startNum).throwBananaTo(banana);

    int numRounds = runSimulation(monkeyList, mw, 1);
    System.out.println("Completed in " + numRounds + " rounds.");

    System.out.println("\nStarting again... \n");
    getFirstMonkey(monkeyList).throwBananaFrom();
    monkeyList.get(startNum).throwBananaTo(banana);
    MonkeyWatcher mw1 = new MonkeyWatcher();
    numRounds = runSimulation(monkeyList, mw1, 2);
    System.out.println("Completed in " + numRounds + " rounds.");
  }
}
