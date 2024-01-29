package com.ardublock.translator.block.dfrobot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class lcdkeypad extends TranslatorBlock {
	
	public lcdkeypad(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	//@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{

		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0, "lcd.print( ", " );\n");
		translator.addHeaderFile("LiquidCrystal.h");
		translator.addDefinitionCommand("LiquidCrystal lcd(4, 6, 10, 11, 12, 13);");
		translator.addSetupCommand("lcd.begin(16, 2);");
		String ret = translatorBlock.toCode();
		return ret;
	}
	
}