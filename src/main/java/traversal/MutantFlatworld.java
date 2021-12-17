package traversal;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  static int X, Y;
  static boolean[][] danger;
  static char[] states = {'N', 'E', 'S', 'W'};
  static Map<Character, Integer> map = new HashMap<>(4);
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

    X = Integer.parseInt(tokenizer.nextToken());
    Y = Integer.parseInt(tokenizer.nextToken());
    danger = new boolean[X+1][Y+1];
    map.put('N', 0);
    map.put('E', 1);
    map.put('S', 2);
    map.put('W', 3);

    String next = "";

    while ((next = reader.readLine()) != null) {
      tokenizer = new StringTokenizer(next);
      int rx = Integer.parseInt(tokenizer.nextToken());
      int ry = Integer.parseInt(tokenizer.nextToken());
      char init = tokenizer.nextToken().charAt(0);

      Robot robot = new Robot(rx, ry, map.get(init));
      String walk = reader.readLine();

      boolean lost = false;
      for (int i = 0; i < walk.length(); i++) {
        if (walk.charAt(i) == 'F') {
          int lx = robot.x, ly = robot.y;
          robot.move();
          if (robot.x < 0 || robot.x > X || robot.y < 0 || robot.y > Y) {
            robot.x = lx;
            robot.y = ly;
            if(danger[lx][ly]){
              continue;
            }
            danger[lx][ly] = true;
            lost = true;
            break;
          }
        } else {
          robot.changeState(walk.charAt(i));
        }

      }
      writer.printf("%d %d %c", robot.x, robot.y, states[robot.state]);
      if(lost)
        writer.println(" LOST");
      else
        writer.println();

    }
    writer.close();
  }

  static class Robot {
    int x;
    int y;
    int state;
    static int[][]  dir= {{0,1}, {1,0}, {0, -1}, {-1, 0}};

    public Robot(int x, int y, int state) {
      this.x = x;
      this.y = y;
      this.state = state;
    }

    public void changeState(char dir) {
      if (dir == 'R') {
        state += 1;
        state %= 4;
      } else if(dir=='L'){
        state -= 1;
        if (state < 0) state = 3;
      }
    }

    public void move() {
      x += dir[state][0];
      y += dir[state][1];
    }
  }
}
