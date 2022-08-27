/**
 * I the undersigned promise that the attached assignment is my own work. While I was
 * free to discuss ideas with others, the work contained is my owm. I recognize that
 * should this not be the case, I will be subject to penalties as outlined in the course
 * syllabus.
 * Haley Coronado 824874564
 */

/**
 * Program #2
 * CS310
 * June 15th, 2021
 * @author Haley Coronado
 * @redId 824874564
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

class Assign2 {
    static class PromotedModel{
        private String model;
        private int promotedPrice;

        public PromotedModel(String m, int p) {
            this.model = m;
            this.promotedPrice = p;
        }

        public String getModel() {
            return model;
        }

        public int getPromotedPrice() {
            return promotedPrice;
        }
    }

    private static class Month  {
        private PromotedModel carModel;
        private PromotedModel highestPriced;
        private PromotedModel lowestPriced;

        public Month(PromotedModel model, PromotedModel highest, PromotedModel lowest){
            this.carModel = model;
            this.highestPriced = highest;
            this.lowestPriced = lowest;
        }
        public PromotedModel getCarModel() {
            return carModel;
        }

        public PromotedModel getHighestPriced() { return highestPriced; }

        public PromotedModel getLowestPriced() { return lowestPriced; }

        public int getHighestPrice(){ return highestPriced.getPromotedPrice(); }

        public int getLowestPrice() { return lowestPriced.getPromotedPrice(); }
    }

    static class PromotedCarModelStack {
        LinkedList<Month> cars = new LinkedList();
        PromotedModel firstCar;

        //Must have O(1) time complexity
        public void push(String model, int price) {
            //create a new PromotedModel object called car
            PromotedModel car = new PromotedModel(model, price);

            //check for first car
            if(cars.isEmpty()){
                //add the new month to the LinkedList
                cars.add(new Month(car, car, car));
                firstCar = car;
            } else {
                //get the most recent month
                Month current = (Month) cars.getLast();

                if (price > current.getHighestPrice()){
                    //add the new month with the new highest price
                    cars.add(new Month(car, car, current.getLowestPriced()));
                } else if (price < current.getLowestPrice()){
                    //add the new month with the new lowest price
                    cars.add(new Month(car, current.getHighestPriced(), car));
                } else {
                    cars.add(new Month(car, current.getHighestPriced(), current.getLowestPriced()));
                }
            }
        }

        //Must have O(1) time complexity and O(1) auxiliary space complexity
        public PromotedModel pop() {
            if (cars.isEmpty()){
                return null;
            } else {
                //return the model from the latest month and remove the month
                PromotedModel car = cars.getLast().getCarModel();
                cars.removeLast();
                return car;
            }
        }

        //Must have O(1) time complexity and O(1) auxiliary space complexity
        public PromotedModel peek() {
            if (cars.isEmpty()){
                return null;
            } else {
                //get and return the model from the latest month
                return cars.getLast().getCarModel();
            }
        }

        //Must have O(1) time complexity and O(1) auxiliary space complexity
        public PromotedModel getHighestPricedPromotedModel() {
            if (cars.isEmpty()){
                return null;
            } else {
                //return the highest priced car from the latest month
                return cars.getLast().getHighestPriced();
            }
        }

        //Must have O(1) time complexity and O(1) auxiliary space complexity
        public PromotedModel getLowestPricedPromotedModel() {
            if (cars.isEmpty()){
                return null;
            } else {
                //return the lowest priced car from the latest month
                return cars.getLast().getLowestPriced();
            }
        }
    }
}