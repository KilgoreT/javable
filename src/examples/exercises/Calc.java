package examples.exercises;

/**
 * Created by apomazkin on 04.12.2017.
 */
public class Calc {
    public static void main(String[] args) {
         /*System.out.print("(1 - 2) * (-3 + 4) --> ");
        System.out.println(getCalc("(1 - 2) * (-3 + 4)"));

        System.out.print("1 + 3 * 2 --> ");
        System.out.println(getCalc("1 + 3 * 2"));

        System.out.print("(1 - 2) * (-3 + 4)*6 --> ");
        System.out.println(getCalc("(1 - 2) * (-3 + 4)*6"));

        System.out.print("(1 + 1 * 2)^2 --> ");
        System.out.println(getCalc("(1 + 1 * 2)^2"));

        System.out.print("-12518 / -569 --> ");
        System.out.println(getCalc("-12518 / -569"));

        System.out.print("3!! --> ");
        System.out.println(getCalc("3!!"));*/

        System.out.print("1787 - 6840 --> ");
        System.out.println(getCalc("1787 - 6840"));

    }

    private static String getCalc(String input) {
        String result;

        input = input.replace(" - ", " s ");
        input = input.replace(" ", "");
        //System.out.println("----------");
        //System.out.println("---> " + input);

        int bP = -1;
        int eP = -1;
        int sAdd = -1;
        int sSub = -1;
        int sMulty = -1;
        int sDiv = -1;
        int sPow = -1;
        int sFact = -1;


        bP = input.indexOf('(');
        eP = input.indexOf(')');
        sAdd = input.indexOf('+');
        sSub = input.indexOf('s');
        sMulty = input.indexOf('*');
        sDiv = input.indexOf('/');
        sPow = input.indexOf('^');
        sFact = input.indexOf('!');

        while ((bP != -1) && (eP != -1)) {
            String inP = input.substring(bP + 1, eP);
            //System.out.println("in (" + inP + ")");
            String subresult = getCalc(inP);
            input = input.substring(0, bP) + subresult + input.substring(eP + 1);
            //System.out.println("new input = " + input);
            bP = input.indexOf('(');
            eP = input.indexOf(')');
        }


        sAdd = input.indexOf('+');
        while (sAdd != -1) {
            String first = input.substring(0, sAdd);
            String second = input.substring(sAdd + 1);
            //System.out.println("first in add: " + first);
            //System.out.println("second in add: " + second);
            Integer intFirst;

            try {
                intFirst = Integer.parseInt(first);
            } catch (NumberFormatException nfe) {
                first = getCalc(first);
                //System.out.println("new first in add: " + first);
                input = first + "+" + second;
                sMulty = input.indexOf('+');
                //System.out.println("!!! new input in add: " + input);
                continue;
            }

            Integer intSec;
            try {
                intSec = Integer.parseInt(second);
            } catch (NumberFormatException nfe) {
                second = getCalc(second);
                //System.out.println("new sec in add: " + second);
                input = first + "+" + second;
                sAdd = input.indexOf('+');
                //System.out.println("---> " + input);
                continue;
            }

            result = String.valueOf(intFirst + intSec);
            sAdd = result.indexOf('+');
            return result;
        }

        sSub = input.indexOf('s');
        while (sSub != -1) {
            String first = input.substring(0, sSub);
            String second = input.substring(sSub + 1);
            //System.out.println("first in add: " + first);
            //System.out.println("second in add: " + second);
            Integer intFirst;

            try {
                intFirst = Integer.parseInt(first);
            } catch (NumberFormatException nfe) {
                first = getCalc(first);
                //System.out.println("new first in sub: " + first);
                input = first + "s" + second;
                sSub = input.indexOf('s');
                //System.out.println("---> " + input);
                continue;
            }

            Integer intSec;
            try {
                intSec = Integer.parseInt(second);
            } catch (NumberFormatException nfe) {
                second = getCalc(second);
                //System.out.println("new sec in sub: " + second);
                input = first + "s" + second;
                sSub = input.indexOf('s');
                //System.out.println("---> " + input);
                continue;
            }

            result = String.valueOf(intFirst - intSec);
            sSub = result.indexOf('s');
            return result;
        }

        sMulty = input.indexOf('*');
        while (sMulty != -1) {
            String first = input.substring(0, sMulty);
            String second = input.substring(sMulty + 1);
            //System.out.println("first in multy: " + first);
            //System.out.println("second in multy: " + second);
            Integer intFirst = null;
            try {
                intFirst = Integer.parseInt(first);
            } catch (NumberFormatException nfe) {
                first = getCalc(first);
                //System.out.println("new first in multy: " + first);
                input = first + "*" + second;
                sMulty = input.indexOf('*');
                //System.out.println("---> " + input);
                continue;
            }

            //System.out.println("first in multy: " + first);
            //System.out.println("second in multy: " + second);

            Integer intSec;
            try {
                intSec = Integer.parseInt(second);
            } catch (NumberFormatException nfe) {
                second = getCalc(second);
                //System.out.println("new first in multy: " + second);
                input = first + "*" + second;
                sMulty = input.indexOf('*');
                //System.out.println("---> " + input);
                continue;
            }

            result = String.valueOf(intFirst * intSec);
            return result;
        }

        // ^
        sPow = input.indexOf('^');
        while (sPow != -1) {
            String first = input.substring(0, sPow);
            String second = input.substring(sPow + 1);
            //System.out.println("first in pow: " + first);
            //System.out.println("second in pow: " + second);
            Integer intFirst = null;
            try {
                intFirst = Integer.parseInt(first);
            } catch (NumberFormatException nfe) {
                first = getCalc(first);
                //System.out.println("new first in pow: " + first);
                input = first + "^" + second;
                sPow = input.indexOf('^');
                //System.out.println("---> " + input);
                continue;
            }

            //System.out.println("first in pow: " + first);
            //System.out.println("second in pow: " + second);

            Integer intSec;
            try {
                intSec = Integer.parseInt(second);
            } catch (NumberFormatException nfe) {
                second = getCalc(second);
                //System.out.println("new first in pow: " + second);
                input = first + "^" + second;
                sPow = input.indexOf('^');
                //System.out.println("---> " + input);
                continue;
            }

            result = String.valueOf((int) Math.pow(intFirst, intSec));
            return result;
        }

        // /
        sDiv = input.indexOf('/');
        while (sDiv != -1) {
            String first = input.substring(0, sDiv);
            String second = input.substring(sDiv + 1);
            //System.out.println("first in div: " + first);
            //System.out.println("second in div: " + second);
            Integer intFirst = null;
            try {
                intFirst = Integer.parseInt(first);
            } catch (NumberFormatException nfe) {
                first = getCalc(first);
                //System.out.println("new first in div: " + first);
                input = first + "/" + second;
                sDiv = input.indexOf('/');
                //System.out.println("---> " + input);
                continue;
            }

            //System.out.println("first in div: " + first);
            //System.out.println("second in div: " + second);

            Integer intSec;
            try {
                intSec = Integer.parseInt(second);
            } catch (NumberFormatException nfe) {
                second = getCalc(second);
                //System.out.println("new first in div: " + second);
                input = first + "/" + second;
                sDiv = input.indexOf('/');
                //System.out.println("---> " + input);
                continue;
            }

            result = String.valueOf(intFirst / intSec);
            return result;
        }

        // !
        sFact = input.indexOf('!');
        while (sFact != -1) {
            String first = input.substring(0, sFact);
            String second = input.substring(sFact + 1);
            //System.out.println("first in fact: " + first);
            //System.out.println("second in fact: " + second);
            Integer intFirst = null;
            try {
                intFirst = Integer.parseInt(first);
            } catch (NumberFormatException nfe) {
                first = getCalc(first);
                //System.out.println("new first in fact: " + first);
                input = first + "!" + second;
                sFact = input.indexOf('!');
                //System.out.println("---> " + input);
                continue;
            }

            //System.out.println("first in fact: " + first);
            //System.out.println("second in fact: " + second);

            /*Integer intSec;
            try {
                intSec = Integer.parseInt(second);
            }
            catch (NumberFormatException nfe) {
                second = getCalc(second);
                //System.out.println("new first in fact: " + second);
                input = first + "!" + second;
                sFact = input.indexOf('!');
                //System.out.println("---> " + input);
                continue;
            }*/

            result = String.valueOf(fact(intFirst));
            if (second.length() > 0) {
                //System.out.println("еще что-то есть");
                input = result + second;
                result = getCalc(input);
            }
            return result;
        }

        return input;
    }

    public static long fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }
}

