module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires org.apache.commons.lang3;
    
    opens edu.fiuba.algo3 to javafx.fxml;

    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.modelo.board.squares;
    exports edu.fiuba.algo3.modelo.attributes;

}