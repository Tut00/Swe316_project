

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;



class NumberedNode extends Group {
	private final double SIDE_LENGTH = 5; 
	private final double NODE_NUMBER_SPACE_LENGTH = 5;
	
	NumberedNode(int number, Color color, double positionX, double positionY) {
		super();
		var square = new Rectangle(positionX, positionY, SIDE_LENGTH, SIDE_LENGTH);
		square.setFill(color);
		var textPositionX = positionX + SIDE_LENGTH + NODE_NUMBER_SPACE_LENGTH;
		var text = new Text(textPositionX, positionY, number+"");
		super.getChildren().addAll(square, text);
	}
}
