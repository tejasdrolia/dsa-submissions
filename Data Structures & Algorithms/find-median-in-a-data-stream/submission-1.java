class MedianFinder {
  PriorityQueue<Integer> left;
  PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    public void addNum(int num) {
        if(right.size()>0 && num>=right.peek())
        right.add(num);
        else
        left.add(num);

        if(right.size() - left.size()==2)
        left.add(right.remove());
        else if(left.size() - right.size()==2)
        right.add(left.remove());
    }
    
    public double findMedian() {
        if(left.size()==right.size())
        {
          double x = (left.peek() + right.peek())*1.0 / 2.0;
          return x;
        }
        else if(left.size()>right.size())
        return left.peek()*1.0;
        else
        return right.peek()*1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */