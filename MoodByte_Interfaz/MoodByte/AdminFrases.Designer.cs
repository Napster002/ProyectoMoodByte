namespace MoodByte
{
    partial class AdminFrases
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
            cmbEstados = new ComboBox();
            dgvFrases = new DataGridView();
            lblEstado = new Label();
            btnBorrar = new Button();
            btnEditar = new Button();
            btnInsertar = new Button();
            navMenu = new Controles.Menu();
            ((System.ComponentModel.ISupportInitialize)dgvFrases).BeginInit();
            SuspendLayout();
            // 
            // cmbEstados
            // 
            cmbEstados.FormattingEnabled = true;
            cmbEstados.Location = new Point(393, 68);
            cmbEstados.Margin = new Padding(3, 4, 3, 4);
            cmbEstados.Name = "cmbEstados";
            cmbEstados.Size = new Size(138, 28);
            cmbEstados.TabIndex = 0;
            cmbEstados.SelectedIndexChanged += cmbEstados_SelectedIndexChanged;
            // 
            // dgvFrases
            // 
            dgvFrases.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvFrases.Location = new Point(115, 136);
            dgvFrases.Margin = new Padding(3, 4, 3, 4);
            dgvFrases.Name = "dgvFrases";
            dgvFrases.RowHeadersWidth = 51;
            dgvFrases.Size = new Size(675, 365);
            dgvFrases.TabIndex = 1;
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Location = new Point(313, 72);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(57, 20);
            lblEstado.TabIndex = 2;
            lblEstado.Text = "Estado:";
            // 
            // btnBorrar
            // 
            btnBorrar.Location = new Point(705, 529);
            btnBorrar.Margin = new Padding(3, 4, 3, 4);
            btnBorrar.Name = "btnBorrar";
            btnBorrar.Size = new Size(86, 31);
            btnBorrar.TabIndex = 3;
            btnBorrar.Text = "Borrar";
            btnBorrar.UseVisualStyleBackColor = true;
            btnBorrar.Click += btnBorrar_Click;
            // 
            // btnEditar
            // 
            btnEditar.Location = new Point(590, 529);
            btnEditar.Margin = new Padding(3, 4, 3, 4);
            btnEditar.Name = "btnEditar";
            btnEditar.Size = new Size(86, 31);
            btnEditar.TabIndex = 4;
            btnEditar.Text = "Editar";
            btnEditar.UseVisualStyleBackColor = true;
            btnEditar.Click += btnEditar_Click;
            // 
            // btnInsertar
            // 
            btnInsertar.Location = new Point(115, 529);
            btnInsertar.Margin = new Padding(3, 4, 3, 4);
            btnInsertar.Name = "btnInsertar";
            btnInsertar.Size = new Size(86, 31);
            btnInsertar.TabIndex = 5;
            btnInsertar.Text = "Añadir";
            btnInsertar.UseVisualStyleBackColor = true;
            btnInsertar.Click += btnInsertar_Click;
            // 
            // navMenu
            // 
            navMenu.BackColor = Color.Transparent;
            navMenu.ForeColor = SystemColors.ControlText;
            navMenu.Location = new Point(14, 3);
            navMenu.Margin = new Padding(3, 5, 3, 5);
            navMenu.Name = "navMenu";
            navMenu.Size = new Size(246, 35);
            navMenu.TabIndex = 6;
            // 
            // AdminFrases
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(914, 600);
            Controls.Add(navMenu);
            Controls.Add(btnInsertar);
            Controls.Add(btnEditar);
            Controls.Add(btnBorrar);
            Controls.Add(lblEstado);
            Controls.Add(dgvFrases);
            Controls.Add(cmbEstados);
            Margin = new Padding(3, 4, 3, 4);
            Name = "AdminFrases";
            Text = "AdminFrases";
            Load += AdminFrases_Load;
            ((System.ComponentModel.ISupportInitialize)dgvFrases).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox cmbEstados;
        private DataGridView dgvFrases;
        private Label lblEstado;
        private Button btnBorrar;
        private Button btnEditar;
        private Button btnInsertar;
        private Controles.Menu navMenu;
    }
}