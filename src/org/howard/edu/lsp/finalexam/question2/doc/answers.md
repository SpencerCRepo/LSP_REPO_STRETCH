The Template Method is used in the Report class by making generateReport() a final method. 
No subclass can change this order, and the four steps are declared abstract in Report. 
Since loadData() is always called first, it will initialize studentName and courseName before the methods run. 
Both subclasses are stored as List<Report> and generateReport() which produces 
the correct report for each type without the loop knowing the concrete class.