public class MyTime implements Cloneable {
    private int value;

    public MyTime(int hour, int min, int sec) {
	if (hour < 0 || min < 0 || min >= 60 || sec < 0 || sec >= 60)
	    throw new IllegalArgumentException("illegal time "+hour+":"+min+":"+sec);
	this.value = hour * 3600 + min * 60 + sec;
    }

    public MyTime(int value) {
	if (value < 0)
	    throw new IllegalArgumentException("illegal time "+value+" seconds");
	this.value = value;
    }
  
    public int getHour() {
	return value / 3600;
    }

    public int getMin() {
	return (value / 60) % 60;
    }

    public int getSec() {
	return value % 60;
    }

    public int getValue() 
    {
	return value;
    }

    public void increment() {
	value++;
    }

    public MyTime add(MyTime other) {
	value += other.value;
	return this;
    }

    public MyTime sub(MyTime other) {
	value -= other.value;
	return this;
    }

    public boolean equals(Object obj) {
	if (obj instanceof MyTime) {
	    MyTime other = (MyTime)obj;
	    return value==other.value;
	}
	else
	    return false;
    }

    public int compareTo(MyTime t) {
	return value - t.value;
    }

    public int hashCode() {
	return value;
    }

    public String toString() {
	int h = getHour();
	int m = getMin();
	int s = getSec();
	return ((h < 10) ? "0" : "") + h + ":" + 
	    ((m < 10) ? "0" : "") + m + ":" +
	    ((s < 10) ? "0" : "") + s;
    }

    public Object clone() {
	return new MyTime(value);
    }
}
