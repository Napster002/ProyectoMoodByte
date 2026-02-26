using System.Windows.Forms;

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
            DataGridViewCellStyle dataGridViewCellStyle4 = new DataGridViewCellStyle();
            DataGridViewCellStyle dataGridViewCellStyle5 = new DataGridViewCellStyle();
            DataGridViewCellStyle dataGridViewCellStyle6 = new DataGridViewCellStyle();
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
            cmbEstado.Location = new Point(681, 52);
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
            lblTipo.Font = new Font("Segoe UI", 10F, FontStyle.Bold);
            lblTipo.ForeColor = Color.FromArgb(245, 109, 95);
            lblTipo.Location = new Point(619, 56);
            lblTipo.Name = "lblTipo";
            lblTipo.Size = new Size(46, 23);
            lblTipo.TabIndex = 2;
            lblTipo.Text = "Tipo";
            // 
            // dgvEjercicio
            // 
            dataGridViewCellStyle4.BackColor = Color.FromArgb(253, 255, 253);
            dgvEjercicio.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle4;
            dgvEjercicio.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgvEjercicio.BackgroundColor = Color.White;
            dgvEjercicio.BorderStyle = BorderStyle.Fixed3D;
            dgvEjercicio.CellBorderStyle = DataGridViewCellBorderStyle.SingleHorizontal;
            dataGridViewCellStyle5.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle5.BackColor = Color.FromArgb(245, 109, 95);
            dataGridViewCellStyle5.Font = new Font("Segoe UI", 11F, FontStyle.Bold);
            dataGridViewCellStyle5.ForeColor = Color.White;
            dataGridViewCellStyle5.SelectionBackColor = SystemColors.Highlight;
            dataGridViewCellStyle5.SelectionForeColor = SystemColors.HighlightText;
            dataGridViewCellStyle5.WrapMode = DataGridViewTriState.True;
            dgvEjercicio.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle5;
            dgvEjercicio.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewCellStyle6.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle6.BackColor = Color.White;
            dataGridViewCellStyle6.Font = new Font("Segoe UI", 10F);
            dataGridViewCellStyle6.ForeColor = Color.Black;
            dataGridViewCellStyle6.SelectionBackColor = Color.FromArgb(96, 245, 216);
            dataGridViewCellStyle6.SelectionForeColor = Color.Black;
            dataGridViewCellStyle6.WrapMode = DataGridViewTriState.False;
            dgvEjercicio.DefaultCellStyle = dataGridViewCellStyle6;
            dgvEjercicio.EnableHeadersVisualStyles = false;
            dgvEjercicio.GridColor = Color.FromArgb(245, 161, 95);
            dgvEjercicio.Location = new Point(74, 98);
            dgvEjercicio.Margin = new Padding(3, 4, 3, 4);
            dgvEjercicio.Name = "dgvEjercicio";
            dgvEjercicio.RowHeadersVisible = false;
            dgvEjercicio.RowHeadersWidth = 51;
            dgvEjercicio.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgvEjercicio.Size = new Size(766, 392);
            dgvEjercicio.TabIndex = 0;
            // 
            // btnInsertarEjercicio
            // 
            btnInsertarEjercicio.BackColor = Color.FromArgb(252, 144, 139);
            btnInsertarEjercicio.FlatAppearance.BorderSize = 0;
            btnInsertarEjercicio.FlatStyle = FlatStyle.Flat;
            btnInsertarEjercicio.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            btnInsertarEjercicio.ForeColor = Color.White;
            btnInsertarEjercicio.Location = new Point(74, 507);
            btnInsertarEjercicio.Margin = new Padding(3, 4, 3, 4);
            btnInsertarEjercicio.Name = "btnInsertarEjercicio";
            btnInsertarEjercicio.Size = new Size(131, 31);
            btnInsertarEjercicio.TabIndex = 4;
            btnInsertarEjercicio.Text = "Añadir";
            btnInsertarEjercicio.UseVisualStyleBackColor = false;
            btnInsertarEjercicio.Click += btnInsertarEjercicio_Click;
            // 
            // btnEditar
            // 
            btnEditar.BackColor = Color.FromArgb(252, 144, 139);
            btnEditar.FlatAppearance.BorderSize = 0;
            btnEditar.FlatStyle = FlatStyle.Flat;
            btnEditar.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            btnEditar.ForeColor = Color.White;
            btnEditar.Location = new Point(588, 507);
            btnEditar.Margin = new Padding(3, 4, 3, 4);
            btnEditar.Name = "btnEditar";
            btnEditar.Size = new Size(110, 31);
            btnEditar.TabIndex = 5;
            btnEditar.Text = "Editar";
            btnEditar.UseVisualStyleBackColor = true;
            btnEditar.Click += btnEditar_Click;
            // 
            // btnBorrar
            // 
            btnBorrar.BackColor = Color.FromArgb(252, 144, 139);
            btnBorrar.FlatAppearance.BorderSize = 0;
            btnBorrar.FlatStyle = FlatStyle.Flat;
            btnBorrar.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            btnBorrar.ForeColor = Color.White;
            btnBorrar.Location = new Point(730, 507);
            btnBorrar.Margin = new Padding(3, 4, 3, 4);
            btnBorrar.Name = "btnBorrar";
            btnBorrar.Size = new Size(110, 31);
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
            BackColor = Color.FromArgb(253, 238, 228);
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
            Text = "Administrar Ejercicios";
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