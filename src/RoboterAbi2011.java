//public class RoboterAbi2011 {
//    public static void main(String[] args) {
//        Roboter myRobot = new Roboter();
//        findeAusgang(myRobot);
//    }
//
//    public void findeAusgang(Roboter roboter) {
//        Stack<Character> stack = new Stack<Character>();
//        while (true) {
//            if (stack.isEmpty()) {
//                while (!roboter.Be_SensorVorne.getHindernis()) {
//                    roboter.vorwärts();
//                }
//                roboter.dreheRechts();
//                stack.push('R');
//            } else {
//                while (!stack.isEmpty()) {
//                    roboter.anWandTasten();
//                    if (roboter.Be_SensorVorne.getHindernis()) {
//                        roboter.dreheRechts();
//                        stack.push('R');
//                    } else {
//                        roboter.dreheLinks();
//                        stack.pop();
//                    }
//                }
//            }
//        }
//    }
// }
