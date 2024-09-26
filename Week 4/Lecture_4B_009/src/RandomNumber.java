class RandomNumber {
  private int value;

  RandomNumber() {
    this.value = (int)(Math.random()*100 + 1);
  }

  public int getValue(){
    return this.value;
  }

  @Override
  public String toString(){
    return "Wow! A random " + this.value + " appeared!";
  }
}