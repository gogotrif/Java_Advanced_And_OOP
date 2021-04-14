package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
    @Test
    public void test() {
        Aquarium aquarium = new Aquarium("testAquarium", 10);
        Assert.assertEquals(aquarium.getCapacity(), 10);
    }

    @Test
    public void test1() {
        Aquarium aquarium = new Aquarium("testAquarium", 10);
        Assert.assertEquals(aquarium.getName(), "testAquarium");
    }

    @Test(expected = NullPointerException.class)
    public void test2() {
        Aquarium aquarium = new Aquarium("  ", 5);
    }

    @Test(expected = NullPointerException.class)
    public void test3() {
        Aquarium aquarium = new Aquarium(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4() {
        Aquarium aquarium = new Aquarium("aquarimName", -1);

    }

    @Test
    public void test5() {
        Aquarium aquarium = new Aquarium("aquarimName", 15);
        Assert.assertEquals(aquarium.getCapacity(), 15);
    }

    @Test
    public void test6() {
        Aquarium aquarium = new Aquarium("aquarimName", 15);
        Fish f1 = new Fish("name");
        Fish f2 = new Fish("name");
        aquarium.add(f1);
        aquarium.add(f2);
        Assert.assertEquals(aquarium.getCount(), 2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        Aquarium aquarium = new Aquarium("aquarimName", 1);
        Fish f1 = new Fish("name");
        Fish f2 = new Fish("name");
        aquarium.add(f1);
        aquarium.add(f2);
        Assert.assertEquals(aquarium.getCount(), 2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test8() {
        Aquarium aquarium = new Aquarium("aquarimName", 1);
        Fish f1 = new Fish("name");
        Fish f2 = new Fish("name2");

        aquarium.remove("name3");

    }

    @Test
    public void test9() {
        Aquarium aquarium = new Aquarium("aquarimName", 5);
        Fish f1 = new Fish("name");
        Fish f2 = new Fish("name2");
        aquarium.add(f1);
        aquarium.add(f2);
        aquarium.remove("name2");
        Assert.assertEquals(aquarium.getCount(), 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test10() {
        Aquarium aquarium = new Aquarium("aquarimName", 1);
        Fish f1 = new Fish("name");
        Fish f2 = new Fish("name2");
        aquarium.sellFish(" ");

    }

    @Test
    public void test11() {
        Aquarium aquarium = new Aquarium("aquarimName", 5);
        Fish f1 = new Fish("name");
        Fish f2 = new Fish("name2");
        aquarium.add(f1);
        aquarium.add(f2);
        aquarium.sellFish("name");
        Assert.assertEquals(f1.isAvailable(),false);

    }
    @Test
    public void test12() {
        Aquarium aquarium = new Aquarium("aquarimName", 5);
        Fish f1 = new Fish("testName");
        Fish f2 = new Fish("name2");
        aquarium.add(f1);
        String name = "testName";

        Assert.assertEquals(aquarium.report(),String.format("Fish available at %s: %s",aquarium.getName(),name));

    }
}

//NullPointerException //NullPointerException IllegalArgumentException
//"Fish available at %s: %s"