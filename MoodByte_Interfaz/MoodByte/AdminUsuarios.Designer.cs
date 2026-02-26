using System.Windows.Forms;

namespace MoodByte
{
    partial class AdminUsuarios
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
            DataGridViewCellStyle dataGridViewCellStyle13 = new DataGridViewCellStyle();
            DataGridViewCellStyle dataGridViewCellStyle14 = new DataGridViewCellStyle();
            DataGridViewCellStyle dataGridViewCellStyle15 = new DataGridViewCellStyle();
            dgvUsuarios = new DataGridView();
            lblUsuarios = new Label();
            btnCrearUsuario = new Button();
            btnEditarusuario = new Button();
            btnBorrarUsuario = new Button();
            navMenu = new Controles.Menu();
            ((System.ComponentModel.ISupportInitialize)dgvUsuarios).BeginInit();
            SuspendLayout();
            // 
            // dgvUsuarios
            // 
            dataGridViewCellStyle13.BackColor = Color.FromArgb(253, 255, 253);
            dgvUsuarios.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle13;
            dgvUsuarios.BackgroundColor = Color.White;
            dgvUsuarios.BorderStyle = BorderStyle.Fixed3D;
            dgvUsuarios.CellBorderStyle = DataGridViewCellBorderStyle.SingleHorizontal;
            dataGridViewCellStyle14.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle14.BackColor = Color.FromArgb(245, 109, 95);
            dataGridViewCellStyle14.Font = new Font("Segoe UI", 11F, FontStyle.Bold);
            dataGridViewCellStyle14.ForeColor = Color.White;
            dataGridViewCellStyle14.SelectionBackColor = SystemColors.Highlight;
            dataGridViewCellStyle14.SelectionForeColor = SystemColors.HighlightText;
            dataGridViewCellStyle14.WrapMode = DataGridViewTriState.True;
            dgvUsuarios.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle14;
            dgvUsuarios.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewCellStyle15.Alignment = DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle15.BackColor = Color.White;
            dataGridViewCellStyle15.Font = new Font("Segoe UI", 10F);
            dataGridViewCellStyle15.ForeColor = Color.Black;
            dataGridViewCellStyle15.SelectionBackColor = Color.FromArgb(96, 245, 216);
            dataGridViewCellStyle15.SelectionForeColor = Color.Black;
            dataGridViewCellStyle15.WrapMode = DataGridViewTriState.False;
            dgvUsuarios.DefaultCellStyle = dataGridViewCellStyle15;
            dgvUsuarios.EnableHeadersVisualStyles = false;
            dgvUsuarios.GridColor = Color.FromArgb(245, 161, 95);
            dgvUsuarios.Location = new Point(71, 79);
            dgvUsuarios.Margin = new Padding(3, 4, 3, 4);
            dgvUsuarios.Name = "dgvUsuarios";
            dgvUsuarios.RowHeadersVisible = false;
            dgvUsuarios.RowHeadersWidth = 51;
            dgvUsuarios.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgvUsuarios.Size = new Size(766, 392);
            dgvUsuarios.TabIndex = 0;
            // 
            // lblUsuarios
            // 
            lblUsuarios.AutoSize = true;
            lblUsuarios.FlatStyle = FlatStyle.Flat;
            lblUsuarios.Font = new Font("Segoe UI", 10F, FontStyle.Bold);
            lblUsuarios.ForeColor = Color.FromArgb(245, 109, 95);
            lblUsuarios.Location = new Point(742, 38);
            lblUsuarios.Name = "lblUsuarios";
            lblUsuarios.Size = new Size(95, 23);
            lblUsuarios.TabIndex = 1;
            lblUsuarios.Text = "USUARIOS";
            // 
            // btnCrearUsuario
            // 
            btnCrearUsuario.BackColor = Color.FromArgb(252, 144, 139);
            btnCrearUsuario.FlatAppearance.BorderSize = 0;
            btnCrearUsuario.FlatStyle = FlatStyle.Flat;
            btnCrearUsuario.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnCrearUsuario.ForeColor = Color.White;
            btnCrearUsuario.Location = new Point(71, 504);
            btnCrearUsuario.Margin = new Padding(3, 4, 3, 4);
            btnCrearUsuario.Name = "btnCrearUsuario";
            btnCrearUsuario.Size = new Size(158, 31);
            btnCrearUsuario.TabIndex = 2;
            btnCrearUsuario.Text = "Crear Nuevo";
            btnCrearUsuario.UseVisualStyleBackColor = false;
            btnCrearUsuario.Click += btnCrearUsuario_Click;
            // 
            // btnEditarusuario
            // 
            btnEditarusuario.BackColor = Color.FromArgb(252, 144, 139);
            btnEditarusuario.FlatAppearance.BorderSize = 0;
            btnEditarusuario.FlatStyle = FlatStyle.Flat;
            btnEditarusuario.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnEditarusuario.ForeColor = Color.White;
            btnEditarusuario.Location = new Point(589, 504);
            btnEditarusuario.Margin = new Padding(3, 4, 3, 4);
            btnEditarusuario.Name = "btnEditarusuario";
            btnEditarusuario.Size = new Size(111, 31);
            btnEditarusuario.TabIndex = 3;
            btnEditarusuario.Text = "Editar";
            btnEditarusuario.UseVisualStyleBackColor = false;
            btnEditarusuario.Click += btnEditarusuario_Click;
            // 
            // btnBorrarUsuario
            // 
            btnBorrarUsuario.BackColor = Color.FromArgb(252, 144, 139);
            btnBorrarUsuario.FlatAppearance.BorderSize = 0;
            btnBorrarUsuario.FlatStyle = FlatStyle.Flat;
            btnBorrarUsuario.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnBorrarUsuario.ForeColor = Color.White;
            btnBorrarUsuario.Location = new Point(726, 504);
            btnBorrarUsuario.Margin = new Padding(3, 4, 3, 4);
            btnBorrarUsuario.Name = "btnBorrarUsuario";
            btnBorrarUsuario.Size = new Size(111, 31);
            btnBorrarUsuario.TabIndex = 4;
            btnBorrarUsuario.Text = "Borrar Usuario";
            btnBorrarUsuario.UseVisualStyleBackColor = false;
            btnBorrarUsuario.Click += btnBorrarUsuario_Click;
            // 
            // navMenu
            // 
            navMenu.BackColor = Color.Transparent;
            navMenu.ForeColor = SystemColors.ControlText;
            navMenu.Location = new Point(14, 4);
            navMenu.Margin = new Padding(3, 5, 3, 5);
            navMenu.Name = "navMenu";
            navMenu.Size = new Size(246, 36);
            navMenu.TabIndex = 5;
            // 
            // AdminUsuarios
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.FromArgb(253, 238, 228);
            ClientSize = new Size(914, 600);
            Controls.Add(navMenu);
            Controls.Add(btnBorrarUsuario);
            Controls.Add(btnEditarusuario);
            Controls.Add(btnCrearUsuario);
            Controls.Add(lblUsuarios);
            Controls.Add(dgvUsuarios);
            Margin = new Padding(3, 4, 3, 4);
            Name = "AdminUsuarios";
            Text = "Administrar Usuarios";
            Load += AdminUsuarios_LoadAsync;
            ((System.ComponentModel.ISupportInitialize)dgvUsuarios).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private DataGridView dgvUsuarios;
        private Label lblUsuarios;
        private Button btnCrearUsuario;
        private Button btnEditarusuario;
        private Button btnBorrarUsuario;
        private Controles.Menu navMenu;
    }
}