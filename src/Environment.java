// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.

import java.util.HashMap;

public class Environment {

    HashMap<String, Double> hashMap = new HashMap<>();

    /**
     * Saves a given varible value pair into the hashmap.
     * @param var The varibles name that is being saved into the hashMap
     * @param val the value of the variable that is being saved into the hashMap
     * @return the val of the varible being saved into the hashMap
     */
    public double put(String var, double val) {
        hashMap.put(var, val);
        return val;
    }

    /**
     * Gets the value for the given variable from the hashmap.
     *
     * @param pos The position of the ...
     * @param var the variable that is being used a key in the hashamp.
     * @return the value that is assisoated with the var key in the hashMap
     * @throws EvalException
     */
    public double get(int pos, String var) throws EvalException {
        double val = hashMap.get(var);
        return val;
    }

}
