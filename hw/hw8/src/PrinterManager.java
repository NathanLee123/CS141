package src;

class PrinterManager extends ResourceManager{
	Printer printers[];
	PrinterManager(int numberOfItems, Printer printers[]){
		super(numberOfItems);
		this.printers = printers;
	}
	
}