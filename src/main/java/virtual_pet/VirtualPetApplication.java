package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) throws InterruptedException {
        //Interact with a VirtualPet object in this method
        VirtualPet myPet = new VirtualPet();
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to name your pet?");
        myPet.petName = input.next();
        System.out.println("You've named your pet" + myPet.petName);

        System.out.println("Now that you've adopted " + myPet.petName + ", you have a lot of responsibility in taking care of them! \n" +
                "Be careful to be attentive to their needs, else they may run away or even die.");
        System.out.println("If the responsibility ever gets to much for you, you can simply type \"quit\" at any time to re-home them.");
        System.out.println("Now, let's introduce " + myPet.petName + " to their new home!");
        System.out.println("When you're ready, just type \"go\" ");

        boolean notReady = true;

        while (notReady) {
            String ready = input.next().toLowerCase();

            if (ready.equals("go")) {
                notReady = false;
            }

        }

        System.out.println(myPet.petName + "seems to be settling in nicely. \n \n");
        System.out.println("（ΦωΦ）\n");
        System.out.println("What would you like to do with " + myPet.petName + "?");

        System.out.println("Type 1 to feed them \n" +
                "Type 2 to give them water \n" +
                "Type 3 to let them outside for a bit \n" +
                "Type 4 to give them a toy \n" +
                "Type 5 to play with them \n" +
                "Type 6 to take them to the vet \n" +
                "Type 7 to do nothing and just stare at your pet \n" +
                "Type \"help\" to see these options again at any time \n" +
                "Type \"quit\" at any time to re-home your pet and leave the game. \n");

        String currentAction = input.next().toLowerCase();

        while (currentAction != "quit") {

            switch (currentAction) {
                case "1":
                    myPet.feed();
                    break;
                case "2":
                    myPet.water();
                    break;
                case "3":
                    myPet.letOut();
                    break;
                case "4":
                    myPet.giveToy();
                    break;
                case "5":
                    myPet.play();
                    break;
                case "6":
                    myPet.vetVisit();
                    break;
                case "7":
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Your pet wonders what you're trying to do, but doesn't seem to react in any way. \n" +
                            "(That's not a valid action.  Please enter a numeral 1-6 to interact with your pet or \"quit\" to quit.)");
                    myPet.tick();
                    break;
            }

            //Evaluate pet needs in order of priority
            if (myPet.petThirst <= 50 && myPet.petThirst >= 26) {
                System.out.println("(Ф∀Ф)");
            } else if (myPet.petThirst <= 25 && myPet.petThirst != 0) {
                System.out.println("(=ΦÅΦ=)");
            } else if (myPet.petThirst == 0) {
                System.out.println("(=xÅx=) \n" +
                        myPet.petName + " has died of thirst!  Try to be more attentive to your next pets needs. \n" +
                        "Thanks for playing.  Murderer.");
                currentAction = "quit";
            } else if (myPet.petHunger <= 50 && myPet.petHunger >= 26) {
                System.out.println("(ФДФ)");
            } else if (myPet.petHunger <= 25 && myPet.petHunger != 0) {
                System.out.println("(ↀДↀ)✧");
            } else if (myPet.petHunger == 0) {
                System.out.println("(xДx)✧ \n" +
                        myPet.petName + " has died of hunger!  Try to be more attentive to your next pets needs. \n" +
                        "Thanks for playing.  Murderer.");
            } else if (myPet.petHealth <= 50 && myPet.petHealth >= 26) {
                System.out.println("(Ф∀Ф)=3");
            } else if (myPet.petHealth <= 25  && myPet.petHealth !=0) {
                System.out.println("(ↀ∀ↀ)=3");
            } else if (myPet.petHealth <= 0) {
                System.out.println("(x∀x)=3 \n" +
                        myPet.petName + " has died from a mysterious illness.  If only you had taken them to the vet in time... \n" +
                        "Thanks for playing.  Murderer.");
            } else if (myPet.petPotty <= 50 && myPet.petPotty >= 26) {
                System.out.println("(Φ∀Φ)=3");
            } else if (myPet.petPotty <= 25 && myPet.petPotty != 0) {
                System.out.println("(Ф∀Ф)=3");
            } else if (myPet.petPotty == 0) {
                System.out.println("（ΦωΦ） \\uD83D\\uDCA9 \n" +
                        "Oh no!  " + myPet.petName + " pooped on the floor!  You should have let them out sooner... \n" +
                        "Hopefully they didn't get sick from holding it for so long.");
                myPet.petHunger -= 20;
            } else if (myPet.petSocial <= 50 && myPet.petSocial >= 26) {
                System.out.println("ヽ(ΦωΦヽ)");
            } else if (myPet.petSocial <= 25 && myPet.petSocial != 0) {
                System.out.println("٩(ↀДↀ)۶");
            } else if (myPet.petSocial == 0) {
                System.out.println("(   ) /n" +
                        "(   ) /n" +
                        "(   ) /n" +
                        "... wait, where's " + myPet.petName + "? \n" +
                        "Oh no, it looks like they ran away!  You should pay more attention to them in the future. \n" +
                        "Thanks for playing.  Hopefully, " + myPet.petName + " is okay out in the cold, dark world on their own.");
            } else if (myPet.petBoredom <= 50 && myPet.petBoredom >= 26) {
                System.out.println("ლ(=ↀωↀ=)ლ");
            } else if (myPet.petBoredom <= 25 && myPet.petBoredom !=0) {
                System.out.println("ლ(=ↀ皿ↀ=)ლ");
            } else if (myPet.petBoredom == 0) {
                System.out.println("||| ლ(=ↀ皿ↀ=)ლ \n" +
                        "Oh no!  " + myPet.petName + "Tore up your drapes! \n" +
                        "You should make sure they have plenty of attention and toys so that they don't get too bored. \n" +
                        "Hopefully they didn't hurt themselves while they were throwing their tantrum.");
                myPet.petHealth -= 20;
            } else {
                System.out.println("（ΦωΦ）");
                myPet.tick();
            }

            currentAction = input.next().toLowerCase();

            myPet.tick();

        }


    }

}
