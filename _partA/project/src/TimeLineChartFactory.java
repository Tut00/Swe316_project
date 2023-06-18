

//import javafx.annotation.Nonnull;
import java.time.LocalDate;

import javafx.scene.paint.Color;

public class TimeLineChartFactory {
	private TimeLineChartFactory() {}

	public static TimeLineChart createTimeLineChart( Project project) {
		var stages = project.getStages();
		if (stages.size() < 1) {
			throw new IllegalArgumentException("Project must have at least 1 stages");
		}

		var eventStartDate = stages.get(0).getDate();
		LocalDate eventEndDate;
		if (stages.size() != 1) {
			eventEndDate = stages.get(stages.size() - 1).getDate();
		}
		else {
			eventEndDate = eventStartDate;
		}
		var timeLineChart = new TimeLineChart(eventStartDate, eventEndDate);

		Color nodeColor;
		int previousStageNumber = -1;
		int currentStageNumber;
		for (Stage stage : stages) {
			currentStageNumber = stage.getNumber();
			if (previousStageNumber <= currentStageNumber) {
				nodeColor = Color.GREEN;
			}
			else {
				nodeColor = Color.RED;
			}

			timeLineChart.addNode(stage.getDate(), stage.getNumber(), nodeColor);
			previousStageNumber = currentStageNumber;
		}

		return timeLineChart;
	}
}
