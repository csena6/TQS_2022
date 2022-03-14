package tqs.lab1;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

public class SimpleStackTest {

    SimpleStack stack;

    @BeforeEach
    void setup(){
        stack = new SimpleStack();
    }
    
    @AfterEach
    void cleanUp(){
        stack = null;
    }

    @Test
    void EmptyConst(){
        assertTrue(stack.isEmpty());
    }


    @Test
    void ZeroSizeConst(){
        assertEquals(0, stack.size());
    }

    @Test
    void afterPush(){
        stack.push(1);
        stack.push(2);

        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
    }

    @Test
    void ValueAfterPushPop(){
        stack.push(1);
        assertEquals(1, stack.pop());
    }

    @Test
    void SizeAfterPushPeek(){
        stack.push(23);
        int currentSize = stack.size();

        assertEquals(23, stack.peek());
        assertEquals(currentSize,stack.size());
    }

    @Test
    void EmptyAfterPop(){
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int currentsize = stack.size();
        for(int i =0; i<currentsize;i++){
            stack.pop();
        }

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void popEmpty(){
        assertThrows(NoSuchElementException.class, () -> {stack.pop();});

    }

    @Test
    void peekEmpty(){
        assertThrows(NoSuchElementException.class, () -> {stack.peek();});

    }

    @Test
    void pushFull(){
        stack = new SimpleStack(2);

        stack.push(1);
        stack.push(2);

        assertThrows(IllegalStateException.class, () -> {stack.pop();});

    }
}
