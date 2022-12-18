package main.java;
// import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;
import java.io.*;


public class BookSaveVisitor implements Visitor {
    private JSONArray jsonArray = new JSONArray();
    private JSONObject objSection;
    private JSONObject objImage;

    private JSONObject objParagraph;
    private JSONObject objImageProxy;
    private JSONObject objItem =  new JSONObject();



    @Override
    public void visitBook(Book book) {
        jsonArray = new JSONArray();
    }

    @Override
    public void visitSection(Section section) {
        objSection = new JSONObject();
        jsonArray.add(objSection);
    }

    @Override
    public void visitTableOfContents(TableOfContents tableOfContents) {


    }

    @Override
    public void visitParagraph(Paragraph paragraph) {
        objParagraph = new JSONObject();
        objParagraph.put("paragraph",paragraph.getText());
        objSection.put("paragraphs",objParagraph);
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        objImageProxy = new JSONObject();
        objImageProxy.put("paragraph",imageProxy.getText());
        objSection.put("imageproxy's",objImageProxy);
    }

    @Override
    public void visitImage(Image image) {
    }

    @Override
    public void visitTable(Table table) {
    }


    void saveJSON(){
        try (FileWriter file = new FileWriter("./test.json")) {
            file.write(jsonArray.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + jsonArray);
        } catch(Exception e){
            System.out.println(e);

        }
    }

}
