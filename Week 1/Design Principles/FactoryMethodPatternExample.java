interface Document { void open(); }
interface WordDocument extends Document{}
interface PdfDocument extends Document{}
interface ExcelDocument extends Document{}

class ConcreteWordDocument implements WordDocument{
    @Override
    public void open() {
        System.out.println("Opening Word Document");
    }
}
class ConcretePdfDocument implements PdfDocument{
    @Override
    public void open() {
        System.out.println("Opening PDF Document");
    }
}
class ConcreteExcelDocument implements ExcelDocument{
    @Override
    public void open() {
        System.out.println("Opening Excel Document");
    }
}

abstract class DocumentFactory{
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new ConcreteWordDocument();
    }
}
class PdfDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new ConcretePdfDocument();
    }
}
class ExcelDocumentFactory extends DocumentFactory{
    @Override
    public Document createDocument() {
        return new ConcreteExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
