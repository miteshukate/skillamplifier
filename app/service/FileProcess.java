package service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import models.Answer;
import models.Option;
import models.Question;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileProcess {

	public static boolean processXltoDB(final File inputFile) {

		try
		{
			final FileInputStream file = new FileInputStream(inputFile);

			//Create Workbook instance holding reference to .xlsx file
			final XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			final XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			final Iterator<Row> rowIterator = sheet.iterator();
			final Question question=new Question();
			while (rowIterator.hasNext())
			{
				final Row row = rowIterator.next();
				//For each row, iterate through all the columns
				final Iterator<Cell> cellIterator = row.cellIterator();

				question.questionName= cellIterator.next().getStringCellValue();
				for(int i=0;i<6;i++){
					final Option option = new Option();
					option.optionName = cellIterator.next().getStringCellValue();
					question.optionList.add(option);
				}
				for(int i=0;i<6;i++){
					if(cellIterator.hasNext()){
						final Answer answer = new Answer();
						answer.answerName = cellIterator.next().getStringCellValue();
						question.answerList.add(answer);
					}
				}
				question.save();
			}
			file.close();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
}
