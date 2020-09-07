package virtual_pet;

public class VirtualPet {

    int petHunger = 100; //Does the pet need food
    int petThirst = 100; //Does the pet need water?
    int petPotty = 100; //Does the pet need to go out?
    int petBoredom = 100; //Is the pet amused?
    int petSocial = 100; //Is the pet lonely?
    int petHealth = 100; //Is the pet healthy
    int time = 0; //How many seconds have passed since last action
    int seed = 0;
    boolean hasToy = false;
    String lastAction = "";
    String petName = "";

    public Object tick() throws InterruptedException {

        Thread.sleep(1000);

        seed = (int) (Math.random() * 99 + 1);

        time++;

        //Begin to evaluate pet needs
        petHunger -= .5;
        petThirst -= 1;
        petPotty -= .5;
        if (hasToy) {
            //pet does not get bored when it has a toy
            if (seed >= 40) {
                hasToy = false;
                System.out.println("Oh no!  " + petName + "'s toy broke!");
            }
        } else {
            petBoredom -= .5; //pet gets bored when it does not have a toy
        }
        petSocial -= .5;
        petHealth -= .1;


        return time;
    }

    public Object feed() {
        petHunger = 100;
        petPotty -= 20;

        lastAction = "You gave " + petName + " some food. \n" +
                "They seem to like it!";

        System.out.println(lastAction);

        if (seed <= 10) {
            petThirst += 20;
            System.out.println(petName + " also laps up some water while they're by the bowl.");
        }

        return petHunger;
    }

    public Object water() {
        petThirst = 100;
        petPotty -= 20;

        lastAction = "You gave " + petName + " some water. \n" +
                "They lap it up eagerly.";

        System.out.println(lastAction);

        return petThirst;

    }

    public Object letOut() {
        petPotty = 100;
        petHunger -= 20;
        petThirst -= 20;

        petBoredom += 20;

        lastAction = "You let " + petName + " out back for a few minutes. \n" +
                "They come in looking relieved.";

        System.out.println(lastAction);

        if (seed <= 10) {
            petSocial += 20;
            System.out.println("It looks like they played with some local animals while they were out.");
        } else if (seed <= 20 && seed >= 11) {
            System.out.println("It looks like " + petName + " found some tasty local treats to munch on while they were out.");
            petHunger += 20;
        } else if (seed <= 30 && seed >= 21) {
            System.out.println(petName + " is very wet.  They probably frolicked around in the water while they were out.");
            petThirst += 20;
        } else if (seed == 99) {
            System.out.println("Oh no!  Looks like " + petName + " got into a bit of a scuffle while they were out.  \n" +
                    "You should really get that looked at...");
            petHealth -= 20;
        }

        return petPotty;
    }

    public Object giveToy() {
        petBoredom = 100;

        hasToy = true;

        lastAction = "You gave " + petName + " a toy. \n" +
                "They paw at it inquisitively. \n" +
                "They shouldn't get bored while they have this toy.";

        System.out.println(lastAction);

        return hasToy;
    }

    public Object play() {
        petSocial = 100;

        petBoredom += 20;

        lastAction = "You played a few rounds of tic-tac-toe with " + petName + "\n" +
                "They seem grateful for the attention.";

        System.out.println(lastAction);

        return petSocial;
    }

    public Object vetVisit() {
        petHealth = 100;
        petSocial -= 20;

        lastAction = "You take " + petName + " to see the vet. \n" +
                "They fight a bit, but come out looking better than ever. \n" +
                "They might need your assurance that you still love them after you took them to see the scary vet...";

        System.out.println(lastAction);

        return petHealth;
    }

}
