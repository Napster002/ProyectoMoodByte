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
            dgvUsuarios.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvUsuarios.Location = new Point(171, 59);
            dgvUsuarios.Name = "dgvUsuarios";
            dgvUsuarios.Size = new Size(582, 294);
            dgvUsuarios.TabIndex = 0;
            // 
            // lblUsuarios
            // 
            lblUsuarios.AutoSize = true;
            lblUsuarios.Location = new Point(701, 29);
            lblUsuarios.Name = "lblUsuarios";
            lblUsuarios.Size = new Size(52, 15);
            lblUsuarios.TabIndex = 1;
            lblUsuarios.Text = "Usuarios";
            // 
            // btnCrearUsuario
            // 
            btnCrearUsuario.Location = new Point(171, 378);
            btnCrearUsuario.Name = "btnCrearUsuario";
            btnCrearUsuario.Size = new Size(102, 23);
            btnCrearUsuario.TabIndex = 2;
            btnCrearUsuario.Text = "Crear Nuevo";
            btnCrearUsuario.UseVisualStyleBackColor = true;
            btnCrearUsuario.Click += btnCrearUsuario_Click;
            // 
            // btnEditarusuario
            // 
            btnEditarusuario.Location = new Point(583, 378);
            btnEditarusuario.Name = "btnEditarusuario";
            btnEditarusuario.Size = new Size(75, 23);
            btnEditarusuario.TabIndex = 3;
            btnEditarusuario.Text = "Editar";
            btnEditarusuario.UseVisualStyleBackColor = true;
            btnEditarusuario.Click += btnEditarusuario_Click;
            // 
            // btnBorrarUsuario
            // 
            btnBorrarUsuario.Location = new Point(678, 378);
            btnBorrarUsuario.Name = "btnBorrarUsuario";
            btnBorrarUsuario.Size = new Size(75, 23);
            btnBorrarUsuario.TabIndex = 4;
            btnBorrarUsuario.Text = "Borrar Usuario";
            btnBorrarUsuario.UseVisualStyleBackColor = true;
            btnBorrarUsuario.Click += btnBorrarUsuario_Click;
            // 
            // navMenu
            // 
            navMenu.BackColor = Color.Transparent;
            navMenu.ForeColor = SystemColors.ControlText;
            navMenu.Location = new Point(12, 3);
            navMenu.Name = "navMenu";
            navMenu.Size = new Size(215, 27);
            navMenu.TabIndex = 5;
            // 
            // AdminUsuarios
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(navMenu);
            Controls.Add(btnBorrarUsuario);
            Controls.Add(btnEditarusuario);
            Controls.Add(btnCrearUsuario);
            Controls.Add(lblUsuarios);
            Controls.Add(dgvUsuarios);
            Name = "AdminUsuarios";
            Text = "AdminUsuarios";
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