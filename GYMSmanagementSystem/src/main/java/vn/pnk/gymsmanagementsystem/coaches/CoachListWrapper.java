package vn.pnk.gymsmanagementsystem.coaches;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vn.pnk.gymsmanagementsystem.utils.XMLUtils;

import java.util.List;

public class CoachListWrapper {

    private ObservableList<Coach> coachList;

    public CoachListWrapper() {
        coachList = FXCollections.observableArrayList();
    }

    public void addCoach(Coach coach) {
        coachList.add(coach);
        saveToXML();
    }

    public void deleteCoach(String coachID) {
        coachList.removeIf(coach -> coach.getCoachId().equals(coachID));
        saveToXML();
    }

    public void updateCoach(String coachID, Coach updatedCoach) {
        for (int i = 0; i < coachList.size(); i++) {
            if (coachList.get(i).getCoachId().equals(coachID)) {
                coachList.set(i, updatedCoach);
                break;
            }
        }
        saveToXML();
    }

    public ObservableList<Coach> getCoachList() {
        return coachList;
    }

    // Đọc dữ liệu từ XML và cập nhật danh sách huấn luyện viên
    public void loadFromXML(String filePath) {
        List<String> data = XMLUtils.readDataFromXML(filePath);
        for (String item : data) {
            String[] coachData = item.split(", ");
            Coach coach = new Coach(coachData[0], coachData[1], coachData[2], coachData[3], coachData[4], coachData[5]);
            coachList.add(coach);
        }
    }

    // Lưu dữ liệu vào XML
    private void saveToXML() {
        XMLUtils.writeDataToXML("coaches.xml", (List<Coach>) coachList);
    }
}
