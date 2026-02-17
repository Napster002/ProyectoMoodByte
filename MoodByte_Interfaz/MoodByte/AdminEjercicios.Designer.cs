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
            cmbEstado = new ComboBox();
            label1 = new Label();
            lblTipo = new Label();
            dgvEjercicio = new DataGridView();
            btnInsertarEjercicio = new Button();
            btnEditar = new Button();
            btnBorrar = new Button();
            navMenu = new Controles.Menu();
            ((System.ComponentModel.ISupportInitialize)dgvEjercicio).BeginInit();
            SuspendLayout();
            // 
            // cmbEstado
            // 
            cmbEstado.FormattingEnabled = true;
            cmbEstado.Location = new Point(398, 75);
            cmbEstado.Margin = new Padding(3, 4, 3, 4);
            cmbEstado.Name = "cmbEstado";
            cmbEstado.Size = new Size(155, 28);
            cmbEstado.TabIndex = 0;
            cmbEstado.SelectedIndexChanged += cmbEstado_SelectedIndexChanged;
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
            lblTipo.Location = new Point(336, 79);
            lblTipo.Name = "lblTipo";
            lblTipo.Size = new Size(42, 20);
            lblTipo.TabIndex = 2;
            lblTipo.Text = "Tipo:";
            // 
            // dgvEjercicio
            // 
            dgvEjercicio.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvEjercicio.Location = new Point(107, 125);
            dgvEjercicio.Margin = new Padding(3, 4, 3, 4);
            dgvEjercicio.Name = "dgvEjercicio";
            dgvEjercicio.RowHeadersWidth = 51;
            dgvEjercicio.Size = new Size(680, 319);
            dgvEjercicio.TabIndex = 3;
            // 
            // btnInsertarEjercicio
            // 
            btnInsertarEjercicio.Location = new Point(107, 475);
            btnInsertarEjercicio.Margin = new Padding(3, 4, 3, 4);
            btnInsertarEjercicio.Name = "btnInsertarEjercicio";
            btnInsertarEjercicio.Size = new Size(131, 31);
            btnInsertarEjercicio.TabIndex = 4;
            btnInsertarEjercicio.Text = "Añadir";
            btnInsertarEjercicio.UseVisualStyleBackColor = true;
            btnInsertarEjercicio.Click += btnInsertarEjercicio_Click;
            // 
            // btnEditar
            // 
            btnEditar.Location = new Point(594, 475);
            btnEditar.Margin = new Padding(3, 4, 3, 4);
            btnEditar.Name = "btnEditar";
            btnEditar.Size = new Size(86, 31);
            btnEditar.TabIndex = 5;
            btnEditar.Text = "Editar";
            btnEditar.UseVisualStyleBackColor = true;
            btnEditar.Click += btnEditar_Click;
            // 
            // btnBorrar
            // 
            btnBorrar.Location = new Point(702, 475);
            btnBorrar.Margin = new Padding(3, 4, 3, 4);
            btnBorrar.Name = "btnBorrar";
            btnBorrar.Size = new Size(86, 31);
            btnBorrar.TabIndex = 6;
            btnBorrar.Text = "Borrar";
            btnBorrar.UseVisualStyleBackColor = true;
            btnBorrar.Click += btnBorrar_Click;
            // 
            // navMenu
            // 
            navMenu.BackColor = Color.Transparent;
            navMenu.ForeColor = SystemColors.ControlText;
            navMenu.Location = new Point(14, 4);
            navMenu.Margin = new Padding(3, 5, 3, 5);
            navMenu.Name = "navMenu";
            navMenu.Size = new Size(246, 39);
            navMenu.TabIndex = 7;
            // 
            // AdminEjercicios
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(914, 600);
            Controls.Add(navMenu);
            Controls.Add(btnBorrar);
            Controls.Add(btnEditar);
            Controls.Add(btnInsertarEjercicio);
            Controls.Add(dgvEjercicio);
            Controls.Add(lblTipo);
            Controls.Add(cmbEstado);
            Margin = new Padding(3, 4, 3, 4);
            Name = "AdminEjercicios";
            Text = "AdminEjercicios";
            Load += AdminEjercicios_Load;
            ((System.ComponentModel.ISupportInitialize)dgvEjercicio).EndInit();
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
        private ComboBox cmbEstado;
        private DataGridView dgvEjercicio;
        private Button btnInsertarEjercicio;
    }
}