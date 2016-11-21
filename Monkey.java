
public class Monkey {

    private static int monkeyNum = 0;
    private int thisMonkeyNum = 0;
    private int id = -1;
    private Banana pb = null;

    /**
     * Get this monkey's number.
     * @return int monkey number
     */

    public int getMonkeyNum() {
      return thisMonkeyNum;
    }

    /**
     * Getter for id.
     * @return id of monkey
     */

    public int getId() throws NoIdException {
      if (id < 0) {
        throw new NoIdException();
      } else {
        return id;
      }
    }

    /**
     * Return which monkey should get banana next.
     * @return int which monkey should get banana.
     */

    public int nextMonkey() {
      if (thisMonkeyNum % 2 == 0) {
        return thisMonkeyNum / 2;
      } else {
        return (thisMonkeyNum * 3) + 1;
      }
    }

    /**
     * Return which monkey should get banana next for 2nd iteration.
     * @return int which monkey should get banana.
     */

    public int nextMonkeySecond() {
      boolean prime = true;
      for (int i = thisMonkeyNum - 1; i > 0; i--) {
        for (int j = 2; j < i; j++) {
          if (i % j == 0) {
            prime = false;
          }
        }
        if (prime) {
          return i;
        } else {
          prime = true;
        }
      }
      return 1;
    }

    /**
     * Checks to see if this monkey has a banana.
     * @return true if has banana, false otherwise
     */

    public boolean hasBanana() {
      return pb != null;
    }

    /**
     * Receive a banana from another monkey.
     * @param ban - Banana given to this monkey
     */

    public void throwBananaTo(Banana ban) {
      pb = ban;
    }

    /**
     *
     * @return Banana - the banana this monkey held.
     */

    public Banana throwBananaFrom() {
      Banana toReturn = pb;
      pb = null;
      return toReturn;
    }

    /**
     * Generate a unique ID for this monkey.
     * Note that monkey ID generation must
     * always return the correct value for
     * a given n (i.e., the id for the first
     * monkey should always be the same).
     * @param num - monkey number
     * @return int - id for this monkey
     */

    public int generateId(int num) {
      return 223492 + num;
    }

    /**
     * Monkey constructor.
     */

    public Monkey() {
      thisMonkeyNum = monkeyNum;
      monkeyNum++;
      id = generateId(thisMonkeyNum);
    }

}
