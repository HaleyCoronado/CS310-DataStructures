/**
 * I the undersigned promise that the attached assignment is my own work. While I was
 * free to discuss ideas with others, the work contained is my owm. I recognize that
 * should this not be the case, I will be subject to penalties as outlined in the course
 * syllabus.
 * Haley Coronado 824874564
 */

/**
 * Program #1
 * CS310
 * June 7th, 2021
 * @author Haley Coronado
 * @redId 824874564
 */

public class Assign1 {
    public String[] sortCarInventory(String[] carInventory, String[] promotionOrder){
        // find the first and last car in the promotion order
        String firstCar = promotionOrder[0];
        String lastCar = promotionOrder[2];

        int frontIndex = 0;
        int endIndex = carInventory.length - 1;

        // sort carInventory based on promotionOrder
        for(int i = 0; i < carInventory.length; i++){
            // check if car belongs at the end
            if(carInventory[i].equals(lastCar) && i < endIndex){
                // check that two end cars aren't being swapped
                while(endIndex >= 0 && carInventory[endIndex].equals(lastCar)){
                    endIndex--;
                }
                if(i < endIndex) {
                    // swap car with end item
                    String tmp = carInventory[endIndex];
                    carInventory[endIndex] = carInventory[i];
                    carInventory[i] = tmp;
                    // decrement lastIndex
                    endIndex--;
                }
            }
            // check if car belongs at front
            if(carInventory[i].equals(firstCar)){
                //swap car with front item
                String tmp = carInventory[frontIndex];
                carInventory[frontIndex] = carInventory[i];
                carInventory[i] = tmp;
                // increment frontIndex
                frontIndex++;
            }
            // check if all values have been sorted
            if(i >= endIndex){
                break;
            }

        }
        // return sorted array
        return carInventory;
    }
}
