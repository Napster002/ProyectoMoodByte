namespace MoodByte
{
    partial class CrearUsuario
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
            components = new System.ComponentModel.Container();
            lblNombre = new Label();
            lblNombreUsuario = new Label();
            lblContraseña = new Label();
            lblGenero = new Label();
            lblTipoUsuario = new Label();
            lblFechanacimiento = new Label();
            tbNombre = new TextBox();
            lblApellidos = new Label();
            tbApellidos = new TextBox();
            dtpFechanacimiento = new DateTimePicker();
            lblFechaRegistro = new Label();
            dtpFechaRegistro = new DateTimePicker();
            cbGenero = new ComboBox();
            cbTipoUsuario = new ComboBox();
            tbNombreUsuario = new TextBox();
            buttonGuardar = new Button();
            tbContraseña = new TextBox();
            epUsuario = new ErrorProvider(components);
            buttonLimpiar = new Button();
            lblrepiteContraseña = new Label();
            tbRepitecontraseña = new TextBox();
            ((System.ComponentModel.ISupportInitialize)epUsuario).BeginInit();
            SuspendLayout();
            // 
            // lblNombre
            // 
            lblNombre.AutoSize = true;
            lblNombre.ForeColor = SystemColors.ButtonHighlight;
            lblNombre.Location = new Point(16, 9);
            lblNombre.Name = "lblNombre";
            lblNombre.Size = new Size(54, 15);
            lblNombre.TabIndex = 0;
            lblNombre.Text = "Nombre ";
            // 
            // lblNombreUsuario
            // 
            lblNombreUsuario.AutoSize = true;
            lblNombreUsuario.ForeColor = SystemColors.ButtonHighlight;
            lblNombreUsuario.Location = new Point(407, 9);
            lblNombreUsuario.Name = "lblNombreUsuario";
            lblNombreUsuario.Size = new Size(94, 15);
            lblNombreUsuario.TabIndex = 1;
            lblNombreUsuario.Text = "Nombre Usuario";
            // 
            // lblContraseña
            // 
            lblContraseña.AutoSize = true;
            lblContraseña.ForeColor = SystemColors.ButtonHighlight;
            lblContraseña.Location = new Point(416, 119);
            lblContraseña.Name = "lblContraseña";
            lblContraseña.Size = new Size(67, 15);
            lblContraseña.TabIndex = 2;
            lblContraseña.Text = "Contraseña";
            // 
            // lblGenero
            // 
            lblGenero.AutoSize = true;
            lblGenero.ForeColor = SystemColors.ButtonHighlight;
            lblGenero.Location = new Point(16, 171);
            lblGenero.Name = "lblGenero";
            lblGenero.Size = new Size(45, 15);
            lblGenero.TabIndex = 4;
            lblGenero.Text = "Genero";
            // 
            // lblTipoUsuario
            // 
            lblTipoUsuario.AutoSize = true;
            lblTipoUsuario.ForeColor = SystemColors.ButtonHighlight;
            lblTipoUsuario.Location = new Point(16, 230);
            lblTipoUsuario.Name = "lblTipoUsuario";
            lblTipoUsuario.Size = new Size(73, 15);
            lblTipoUsuario.TabIndex = 5;
            lblTipoUsuario.Text = "Tipo Usuario";
            // 
            // lblFechanacimiento
            // 
            lblFechanacimiento.AutoSize = true;
            lblFechanacimiento.ForeColor = SystemColors.ButtonHighlight;
            lblFechanacimiento.Location = new Point(16, 119);
            lblFechanacimiento.Name = "lblFechanacimiento";
            lblFechanacimiento.Size = new Size(117, 15);
            lblFechanacimiento.TabIndex = 6;
            lblFechanacimiento.Text = "Fecha de nacimineto";
            // 
            // tbNombre
            // 
            tbNombre.Location = new Point(16, 27);
            tbNombre.Name = "tbNombre";
            tbNombre.Size = new Size(157, 23);
            tbNombre.TabIndex = 7;
            // 
            // lblApellidos
            // 
            lblApellidos.AutoSize = true;
            lblApellidos.ForeColor = SystemColors.ButtonHighlight;
            lblApellidos.Location = new Point(16, 64);
            lblApellidos.Name = "lblApellidos";
            lblApellidos.Size = new Size(56, 15);
            lblApellidos.TabIndex = 8;
            lblApellidos.Text = "Apellidos";
            // 
            // tbApellidos
            // 
            tbApellidos.Location = new Point(16, 82);
            tbApellidos.Name = "tbApellidos";
            tbApellidos.Size = new Size(157, 23);
            tbApellidos.TabIndex = 9;
            // 
            // dtpFechanacimiento
            // 
            dtpFechanacimiento.Location = new Point(16, 137);
            dtpFechanacimiento.Name = "dtpFechanacimiento";
            dtpFechanacimiento.Size = new Size(235, 23);
            dtpFechanacimiento.TabIndex = 10;
            // 
            // lblFechaRegistro
            // 
            lblFechaRegistro.AutoSize = true;
            lblFechaRegistro.ForeColor = SystemColors.ButtonHighlight;
            lblFechaRegistro.Location = new Point(407, 64);
            lblFechaRegistro.Name = "lblFechaRegistro";
            lblFechaRegistro.Size = new Size(100, 15);
            lblFechaRegistro.TabIndex = 11;
            lblFechaRegistro.Text = "Fecha de Registro";
            // 
            // dtpFechaRegistro
            // 
            dtpFechaRegistro.Location = new Point(346, 82);
            dtpFechaRegistro.Name = "dtpFechaRegistro";
            dtpFechaRegistro.Size = new Size(218, 23);
            dtpFechaRegistro.TabIndex = 12;
            // 
            // cbGenero
            // 
            cbGenero.FormattingEnabled = true;
            cbGenero.Location = new Point(16, 192);
            cbGenero.Name = "cbGenero";
            cbGenero.Size = new Size(157, 23);
            cbGenero.TabIndex = 13;
            // 
            // cbTipoUsuario
            // 
            cbTipoUsuario.FormattingEnabled = true;
            cbTipoUsuario.Location = new Point(16, 248);
            cbTipoUsuario.Name = "cbTipoUsuario";
            cbTipoUsuario.Size = new Size(157, 23);
            cbTipoUsuario.TabIndex = 14;
            // 
            // tbNombreUsuario
            // 
            tbNombreUsuario.Location = new Point(407, 27);
            tbNombreUsuario.Name = "tbNombreUsuario";
            tbNombreUsuario.Size = new Size(157, 23);
            tbNombreUsuario.TabIndex = 15;
            // 
            // buttonGuardar
            // 
            buttonGuardar.Location = new Point(416, 287);
            buttonGuardar.Name = "buttonGuardar";
            buttonGuardar.Size = new Size(75, 23);
            buttonGuardar.TabIndex = 16;
            buttonGuardar.Text = "Guardar";
            buttonGuardar.UseVisualStyleBackColor = true;
            buttonGuardar.Click += buttonGuardar_Click;
            // 
            // tbContraseña
            // 
            tbContraseña.Location = new Point(407, 140);
            tbContraseña.Name = "tbContraseña";
            tbContraseña.Size = new Size(157, 23);
            tbContraseña.TabIndex = 17;
            tbContraseña.UseSystemPasswordChar = true;
            // 
            // epUsuario
            // 
            epUsuario.ContainerControl = this;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.Location = new Point(299, 287);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(75, 23);
            buttonLimpiar.TabIndex = 18;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = true;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // lblrepiteContraseña
            // 
            lblrepiteContraseña.AutoSize = true;
            lblrepiteContraseña.ForeColor = SystemColors.ButtonHighlight;
            lblrepiteContraseña.Location = new Point(407, 171);
            lblrepiteContraseña.Name = "lblrepiteContraseña";
            lblrepiteContraseña.Size = new Size(113, 15);
            lblrepiteContraseña.TabIndex = 19;
            lblrepiteContraseña.Text = "Repite la contraseña";
            // 
            // tbRepitecontraseña
            // 
            tbRepitecontraseña.Location = new Point(407, 192);
            tbRepitecontraseña.Name = "tbRepitecontraseña";
            tbRepitecontraseña.Size = new Size(157, 23);
            tbRepitecontraseña.TabIndex = 20;
            tbRepitecontraseña.UseSystemPasswordChar = true;
            // 
            // CrearUsuario
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.MediumPurple;
            ClientSize = new Size(579, 357);
            Controls.Add(tbRepitecontraseña);
            Controls.Add(lblrepiteContraseña);
            Controls.Add(buttonLimpiar);
            Controls.Add(tbContraseña);
            Controls.Add(buttonGuardar);
            Controls.Add(tbNombreUsuario);
            Controls.Add(cbTipoUsuario);
            Controls.Add(cbGenero);
            Controls.Add(dtpFechaRegistro);
            Controls.Add(lblFechaRegistro);
            Controls.Add(dtpFechanacimiento);
            Controls.Add(tbApellidos);
            Controls.Add(lblApellidos);
            Controls.Add(tbNombre);
            Controls.Add(lblFechanacimiento);
            Controls.Add(lblTipoUsuario);
            Controls.Add(lblGenero);
            Controls.Add(lblContraseña);
            Controls.Add(lblNombreUsuario);
            Controls.Add(lblNombre);
            Name = "CrearUsuario";
            Text = "CrearUsuario";
            Load += CrearUsuario_Load;
            ((System.ComponentModel.ISupportInitialize)epUsuario).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblNombre;
        private Label lblNombreUsuario;
        private Label lblContraseña;
        private Label lblGenero;
        private Label lblTipoUsuario;
        private Label lblFechanacimiento;
        private TextBox tbNombre;
        private Label lblApellidos;
        private TextBox tbApellidos;
        private DateTimePicker dtpFechanacimiento;
        private Label lblFechaRegistro;
        private DateTimePicker dtpFechaRegistro;
        private ComboBox cbGenero;
        private ComboBox cbTipoUsuario;
        private TextBox tbNombreUsuario;
        private Button buttonGuardar;
        private TextBox tbContraseña;
        private ErrorProvider epUsuario;
        private Button buttonLimpiar;
        private TextBox tbRepitecontraseña;
        private Label lblrepiteContraseña;
    }
}