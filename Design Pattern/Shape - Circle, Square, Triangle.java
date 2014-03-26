interface Graphics{
   void drawLine(int[] start, int[] end)
   void drawCircle(int[] center, int radius)
}

circle, square, triangle

class Color{
}

class Shape{
	Color color;

	// opt 1: 
	public abstract void draw(Graphics g);

	
	// opt 2: incorect
	public void draw(Graphics g){
		if(this instanceof Circle)
			g.drawCircle(coordinate, radius);
			if(this instanceof Square || this instanceof Triangle){
				for(int i = 1; i < s.coordinate.length; i ++)
			g.drawLine(s.coordinate[i - 1], s.coordinate[i]);
			g.drawLine(s.coordinate[0], s.coodinate[s.coordinate.length - 1];
		}
	}
}




class Circle extends Shape{
	int radius;
	int[] coordinate = new int[2];
	
	public void draw(Graphics g){
		g.drawCircle(coordinate, radius);
	}
}

class Square extends Shape{
	int height;
	int[][] coordinate = new int[4][2];
	public void draw(Graphics g){
		for(int i = 1; i < s.coordinate.length; i ++)
		g.drawLine(s.coordinate[i - 1], s.coordinate[i]);
		g.drawLine(s.coordinate[0], s.coodinate[s.coordinate.length - 1];
	}
}
class Triangle extends Shape{
	int[] edge = new int[3];
	int[][] coordinate = new int[3][2];
	public void draw(Graphics g){
		for(int i = 1; i < s.coordinate.length; i ++)
			g.drawLine(s.coordinate[i - 1], s.coordinate[i]);
		g.drawLine(s.coordinate[0], s.coodinate[s.coordinate.length - 1];
	}
}

draw(ArrayList<Shape> list, Graphics g){
	for(Shape s : list){
		s.draw(g);
	}
}

ArrayList<Circile> 
ArrayList<Square>
ArrayList<Triangle>
 -> merge ->
ArrayList<Shape> 



