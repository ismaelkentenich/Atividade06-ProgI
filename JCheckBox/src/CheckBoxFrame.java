// Criando bot�es JCheckBox 

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame {
	private JTextField textField; // exibe o texto na altera��o de fontes
	private JCheckBox boldJCheckBox; // para selecionar estilo negrito/remover a sele��o do estilo negrito
	private JCheckBox italicJCheckBox; // para selecionar it�lico/remover a sele��o do estilo it�lico
	
	// construtor CheckBoxFrame adiciona JCheckBoxes ao JFrame
	public CheckBoxFrame() {
		super( "JCheckBox Test" );
		setLayout( new FlowLayout() ); // configura o layout de frame
		
		// configura JTextField e sua fonte
		textField = new JTextField( "Olhe o estilo da fonte mudar.", 20 );
		textField.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
		add( textField ); // adiciona textField ao JFrame
		
		boldJCheckBox = new JCheckBox("Bold"); // cria caixa de sele��o para negrito
		italicJCheckBox = new JCheckBox( "Italic" ); // cria it�lico
		add(boldJCheckBox); // adiciona caixa de sele��o de estilo negrito ao JFrame
		add(italicJCheckBox); // adiciona caixa de sele��o de it�lico ao JFrame
		
		// listeners registradores para JCheckBoxes
		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener( handler );
		boldJCheckBox.addItemListener( handler );
		}// fim do construtor CheckBoxFrame
	
	// classe interna private para tratamento de evento ItemListener
	private class CheckBoxHandler implements ItemListener{
		// responde aos eventos de caixa de sele��o
		public void itemStateChanged( ItemEvent event ) {
			Font font = null; // armazena a nova Font
			
			// determina que CheckBoxes est�o marcadas e cria Font
			if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected() )
				font = new Font( "Serif", Font.BOLD + Font.ITALIC, 14 );
			else if (boldJCheckBox.isSelected() )
				font = new Font( "Serif", Font.BOLD, 14 );
			else if (italicJCheckBox.isSelected() )
				font = new Font( "Serif", Font.ITALIC, 14 );
			else
				font = new Font( "Serif", Font.PLAIN, 14 );
			
			textField.setFont( font ); // configura a fonte do textField
					
		} // fim do m�todo itemStateChanged
	}// fim da classe CheckBoxHandler interna private
	
	
}// fim da classe CheckBoxFrame
