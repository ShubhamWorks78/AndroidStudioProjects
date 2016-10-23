import android.graphics.drawable.shapes.RectShape;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shubham on 5/15/2016.
 */

public class Sandbox extends RectShape{
    private List<String> mGreetings = new ArrayList<String>();

    @Override
    public boolean hasAlpha() {
        return true;
    }

    @Override
    public String toString() {
        return "Sandbox{" + "mGreetings=" + mGreetings + '}';
    }

    public Sandbox() {

    }

    public List<String> getGreetings() {
        return mGreetings;
    }

    public void setGreetings(List<String> greetings) {
        mGreetings = greetings;
    }

}
