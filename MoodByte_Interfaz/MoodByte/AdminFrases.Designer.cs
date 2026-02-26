using System.Windows.Forms;

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
            DataGridViewCellStyle dataGridViewCellStyle1 = new DataGridViewCellStyle();
            DataGridViewCellStyle dataGridViewCellStyle2 = new DataGridViewCellStyle();
            DataGridViewCellStyle dataGridViewCellStyle3 = new DataGridViewCellStyle();
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
            cmbEstados.Location = new Point(657, 65);
            cmbEstados.Margin = new Padding(3, 4, 3, 4);
            cmbEstados.Name = "cmbEstados";
            cmbEstados.Size = new Size(138, 28);
            cmbEstados.TabIndex = 0;
            cmbEstados.SelectedIndexChanged += cmbEstados_SelectedIndexChanged;
            // 
            // dgvFrases
            // 
            dataGridViewCellStyle1.BackColor = Color.FromArgb(253, 255, 253);
            dgvFrases.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle1;
            dgvFrases.BackgroundColor = Color.White;
            dgvFrases.BorderStyle = BorderStyle.Fixed3D;
            dgvFrases.CellBorderStyle = DataGridViewCellBorderStyle.SingleHorizontal;
            dataGridViewCellStyle2.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = Color.FromArgb(245, 109, 95);
            dataGridViewCellStyle2.Font = new Font("Segoe UI", 11F, FontStyle.Bold);
            dataGridViewCellStyle2.ForeColor = Color.White;
            dataGridViewCellStyle2.SelectionBackColor = SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = DataGridViewTriState.True;
            dgvFrases.AutoSizeColumnsMode= DataGridViewAutoSizeColumnsMode.Fill;
            dgvFrases.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle2;
            dgvFrases.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewCellStyle3.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle3.BackColor = Color.White;
            dataGridViewCellStyle3.Font = new Font("Segoe UI", 10F);
            dataGridViewCellStyle3.ForeColor = Color.Black;
            dataGridViewCellStyle3.SelectionBackColor = Color.FromArgb(96, 245, 216);
            dataGridViewCellStyle3.SelectionForeColor = Color.Black;
            dataGridViewCellStyle3.WrapMode = DataGridViewTriState.False;
            dgvFrases.DefaultCellStyle = dataGridViewCellStyle3;
            dgvFrases.EnableHeadersVisualStyles = false;
            dgvFrases.Location = new Point(119, 118);
            dgvFrases.Margin = new Padding(3, 4, 3, 4);
            dgvFrases.Name = "dgvFrases";
            dgvFrases.RowHeadersWidth = 51;
            dgvFrases.Size = new Size(675, 365);
            dgvFrases.TabIndex = 1;
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Font = new Font("Segoe UI", 10F, FontStyle.Bold);
            lblEstado.ForeColor = Color.FromArgb(245, 109, 95);
            lblEstado.Location = new Point(588, 66);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(63, 23);
            lblEstado.TabIndex = 2;
            lblEstado.Text = "Estado";
            // 
            // btnBorrar
            // 
            btnBorrar.BackColor = Color.FromArgb(252, 144, 139);
            btnBorrar.FlatAppearance.BorderSize = 0;
            btnBorrar.FlatStyle = FlatStyle.Flat;
            btnBorrar.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            btnBorrar.ForeColor = Color.White;
            btnBorrar.Location = new Point(673, 511);
            btnBorrar.Margin = new Padding(3, 4, 3, 4);
            btnBorrar.Name = "btnBorrar";
            btnBorrar.Size = new Size(122, 31);
            btnBorrar.TabIndex = 3;
            btnBorrar.Text = "Borrar";
            btnBorrar.UseVisualStyleBackColor = false;
            btnBorrar.Click += btnBorrar_Click;
            // 
            // btnEditar
            // 
            btnEditar.BackColor = Color.FromArgb(252, 144, 139);
            btnEditar.FlatAppearance.BorderSize = 0;
            btnEditar.FlatStyle = FlatStyle.Flat;
            btnEditar.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            btnEditar.ForeColor = Color.White;
            btnEditar.Location = new Point(530, 511);
            btnEditar.Margin = new Padding(3, 4, 3, 4);
            btnEditar.Name = "btnEditar";
            btnEditar.Size = new Size(122, 31);
            btnEditar.TabIndex = 4;
            btnEditar.Text = "Editar";
            btnEditar.UseVisualStyleBackColor = false;
            btnEditar.Click += btnEditar_Click;
            // 
            // btnInsertar
            // 
            btnInsertar.BackColor = Color.FromArgb(252, 144, 139);
            btnInsertar.FlatAppearance.BorderSize = 0;
            btnInsertar.FlatStyle = FlatStyle.Flat;
            btnInsertar.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            btnInsertar.ForeColor = Color.White;
            btnInsertar.Location = new Point(119, 511);
            btnInsertar.Margin = new Padding(3, 4, 3, 4);
            btnInsertar.Name = "btnInsertar";
            btnInsertar.Size = new Size(145, 31);
            btnInsertar.TabIndex = 5;
            btnInsertar.Text = "Añadir";
            btnInsertar.UseVisualStyleBackColor = false;
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
            BackColor = Color.FromArgb(253, 238, 228);
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
            Text = "Administrar Frases";
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