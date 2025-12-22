namespace MoodByte
{
    partial class AdminEjercicios
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            comboBox1 = new ComboBox();
            label1 = new Label();
            lblTipo = new Label();
            dataGridView1 = new DataGridView();
            btnInsertarFrase = new Button();
            btnEditar = new Button();
            btnBorrar = new Button();
            navMenu = new Controles.Menu();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).BeginInit();
            SuspendLayout();
            // 
            // comboBox1
            // 
            comboBox1.FormattingEnabled = true;
            comboBox1.Location = new Point(348, 56);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(136, 23);
            comboBox1.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(123, 53);
            label1.Name = "label1";
            label1.Size = new Size(0, 15);
            label1.TabIndex = 1;
            // 
            // lblTipo
            // 
            lblTipo.AutoSize = true;
            lblTipo.Location = new Point(294, 59);
            lblTipo.Name = "lblTipo";
            lblTipo.Size = new Size(33, 15);
            lblTipo.TabIndex = 2;
            lblTipo.Text = "Tipo:";
            // 
            // dataGridView1
            // 
            dataGridView1.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridView1.Location = new Point(94, 94);
            dataGridView1.Name = "dataGridView1";
            dataGridView1.Size = new Size(595, 239);
            dataGridView1.TabIndex = 3;
            // 
            // btnInsertarFrase
            // 
            btnInsertarFrase.Location = new Point(94, 356);
            btnInsertarFrase.Name = "btnInsertarFrase";
            btnInsertarFrase.Size = new Size(115, 23);
            btnInsertarFrase.TabIndex = 4;
            btnInsertarFrase.Text = "Nueva Frase";
            btnInsertarFrase.UseVisualStyleBackColor = true;
            // 
            // btnEditar
            // 
            btnEditar.Location = new Point(520, 356);
            btnEditar.Name = "btnEditar";
            btnEditar.Size = new Size(75, 23);
            btnEditar.TabIndex = 5;
            btnEditar.Text = "Editar";
            btnEditar.UseVisualStyleBackColor = true;
            // 
            // btnBorrar
            // 
            btnBorrar.Location = new Point(614, 356);
            btnBorrar.Name = "btnBorrar";
            btnBorrar.Size = new Size(75, 23);
            btnBorrar.TabIndex = 6;
            btnBorrar.Text = "Borrar";
            btnBorrar.UseVisualStyleBackColor = true;
            // 
            // navMenu
            // 
            navMenu.BackColor = Color.Transparent;
            navMenu.ForeColor = SystemColors.ControlText;
            navMenu.Location = new Point(12, 3);
            navMenu.Name = "navMenu";
            navMenu.Size = new Size(215, 29);
            navMenu.TabIndex = 7;
            // 
            // AdminEjercicios
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(navMenu);
            Controls.Add(btnBorrar);
            Controls.Add(btnEditar);
            Controls.Add(btnInsertarFrase);
            Controls.Add(dataGridView1);
            Controls.Add(lblTipo);
            Controls.Add(comboBox1);
            Name = "AdminEjercicios";
            Text = "AdminEjercicios";
            ((System.ComponentModel.ISupportInitialize)dataGridView1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox comboBox1;
        private Label label1;
        private Label lblTipo;
        private DataGridView dataGridView1;
        private Button btnInsertarFrase;
        private Button btnEditar;
        private Button btnBorrar;
        private Controles.Menu navMenu;
    }
}