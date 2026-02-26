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
            lblNombre.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lblNombre.ForeColor = Color.FromArgb(245, 109, 95);
            lblNombre.Location = new Point(85, 15);
            lblNombre.Name = "lblNombre";
            lblNombre.Size = new Size(71, 20);
            lblNombre.TabIndex = 0;
            lblNombre.Text = "Nombre ";
            // 
            // lblNombreUsuario
            // 
            lblNombreUsuario.AutoSize = true;
            lblNombreUsuario.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblNombreUsuario.ForeColor = Color.FromArgb(245, 109, 95);
            lblNombreUsuario.Location = new Point(85, 178);
            lblNombreUsuario.Name = "lblNombreUsuario";
            lblNombreUsuario.Size = new Size(125, 20);
            lblNombreUsuario.TabIndex = 1;
            lblNombreUsuario.Text = "Nombre Usuario";
            // 
            // lblContraseña
            // 
            lblContraseña.AutoSize = true;
            lblContraseña.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblContraseña.ForeColor = Color.FromArgb(245, 109, 95);
            lblContraseña.Location = new Point(359, 15);
            lblContraseña.Name = "lblContraseña";
            lblContraseña.Size = new Size(88, 20);
            lblContraseña.TabIndex = 2;
            lblContraseña.Text = "Contraseña";
            // 
            // lblGenero
            // 
            lblGenero.AutoSize = true;
            lblGenero.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblGenero.ForeColor = Color.FromArgb(245, 109, 95);
            lblGenero.Location = new Point(85, 261);
            lblGenero.Name = "lblGenero";
            lblGenero.Size = new Size(60, 20);
            lblGenero.TabIndex = 4;
            lblGenero.Text = "Genero";
            // 
            // lblTipoUsuario
            // 
            lblTipoUsuario.AutoSize = true;
            lblTipoUsuario.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblTipoUsuario.ForeColor = Color.FromArgb(245, 109, 95);
            lblTipoUsuario.Location = new Point(85, 344);
            lblTipoUsuario.Name = "lblTipoUsuario";
            lblTipoUsuario.Size = new Size(98, 20);
            lblTipoUsuario.TabIndex = 5;
            lblTipoUsuario.Text = "Tipo Usuario";
            // 
            // lblFechanacimiento
            // 
            lblFechanacimiento.AutoSize = true;
            lblFechanacimiento.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblFechanacimiento.ForeColor = Color.FromArgb(245, 109, 95);
            lblFechanacimiento.Location = new Point(359, 178);
            lblFechanacimiento.Name = "lblFechanacimiento";
            lblFechanacimiento.Size = new Size(152, 20);
            lblFechanacimiento.TabIndex = 6;
            lblFechanacimiento.Text = "Fecha de nacimineto";
            // 
            // tbNombre
            // 
            tbNombre.BorderStyle = BorderStyle.FixedSingle;
            tbNombre.Location = new Point(85, 39);
            tbNombre.Margin = new Padding(3, 4, 3, 4);
            tbNombre.Name = "tbNombre";
            tbNombre.Size = new Size(179, 27);
            tbNombre.TabIndex = 7;
            // 
            // lblApellidos
            // 
            lblApellidos.AutoSize = true;
            lblApellidos.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblApellidos.ForeColor = Color.FromArgb(245, 109, 95);
            lblApellidos.Location = new Point(85, 95);
            lblApellidos.Name = "lblApellidos";
            lblApellidos.Size = new Size(74, 20);
            lblApellidos.TabIndex = 8;
            lblApellidos.Text = "Apellidos";
            // 
            // tbApellidos
            // 
            tbApellidos.BorderStyle = BorderStyle.FixedSingle;
            tbApellidos.Location = new Point(85, 121);
            tbApellidos.Margin = new Padding(3, 4, 3, 4);
            tbApellidos.Name = "tbApellidos";
            tbApellidos.Size = new Size(179, 27);
            tbApellidos.TabIndex = 9;
            // 
            // dtpFechanacimiento
            // 
            dtpFechanacimiento.Location = new Point(359, 206);
            dtpFechanacimiento.Margin = new Padding(3, 4, 3, 4);
            dtpFechanacimiento.Name = "dtpFechanacimiento";
            dtpFechanacimiento.Size = new Size(268, 27);
            dtpFechanacimiento.TabIndex = 10;
            // 
            // lblFechaRegistro
            // 
            lblFechaRegistro.AutoSize = true;
            lblFechaRegistro.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblFechaRegistro.ForeColor = Color.FromArgb(245, 109, 95);
            lblFechaRegistro.Location = new Point(359, 259);
            lblFechaRegistro.Name = "lblFechaRegistro";
            lblFechaRegistro.Size = new Size(133, 20);
            lblFechaRegistro.TabIndex = 11;
            lblFechaRegistro.Text = "Fecha de Registro";
            // 
            // dtpFechaRegistro
            // 
            dtpFechaRegistro.Location = new Point(359, 283);
            dtpFechaRegistro.Margin = new Padding(3, 4, 3, 4);
            dtpFechaRegistro.Name = "dtpFechaRegistro";
            dtpFechaRegistro.Size = new Size(268, 27);
            dtpFechaRegistro.TabIndex = 12;
            // 
            // cbGenero
            // 
            cbGenero.FormattingEnabled = true;
            cbGenero.Location = new Point(85, 285);
            cbGenero.Margin = new Padding(3, 4, 3, 4);
            cbGenero.Name = "cbGenero";
            cbGenero.Size = new Size(179, 28);
            cbGenero.TabIndex = 13;
            // 
            // cbTipoUsuario
            // 
            cbTipoUsuario.FormattingEnabled = true;
            cbTipoUsuario.Location = new Point(85, 368);
            cbTipoUsuario.Margin = new Padding(3, 4, 3, 4);
            cbTipoUsuario.Name = "cbTipoUsuario";
            cbTipoUsuario.Size = new Size(179, 28);
            cbTipoUsuario.TabIndex = 14;
            // 
            // tbNombreUsuario
            // 
            tbNombreUsuario.BorderStyle = BorderStyle.FixedSingle;
            tbNombreUsuario.Location = new Point(85, 203);
            tbNombreUsuario.Margin = new Padding(3, 4, 3, 4);
            tbNombreUsuario.Name = "tbNombreUsuario";
            tbNombreUsuario.Size = new Size(179, 27);
            tbNombreUsuario.TabIndex = 15;
            // 
            // buttonGuardar
            // 
            buttonGuardar.BackColor = Color.FromArgb(252, 144, 139);
            buttonGuardar.FlatAppearance.BorderSize = 0;
            buttonGuardar.FlatStyle = FlatStyle.Flat;
            buttonGuardar.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            buttonGuardar.ForeColor = Color.White;
            buttonGuardar.Location = new Point(517, 365);
            buttonGuardar.Margin = new Padding(3, 4, 3, 4);
            buttonGuardar.Name = "buttonGuardar";
            buttonGuardar.Size = new Size(110, 31);
            buttonGuardar.TabIndex = 16;
            buttonGuardar.Text = "Guardar";
            buttonGuardar.UseVisualStyleBackColor = true;
            buttonGuardar.Click += buttonGuardar_Click;
            // 
            // tbContraseña
            // 
            tbContraseña.BorderStyle = BorderStyle.FixedSingle;
            tbContraseña.Location = new Point(359, 39);
            tbContraseña.Margin = new Padding(3, 4, 3, 4);
            tbContraseña.Name = "tbContraseña";
            tbContraseña.Size = new Size(179, 27);
            tbContraseña.TabIndex = 17;
            tbContraseña.UseSystemPasswordChar = true;
            // 
            // epUsuario
            // 
            epUsuario.ContainerControl = this;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.BackColor = Color.FromArgb(252, 144, 139);
            buttonLimpiar.FlatAppearance.BorderSize = 0;
            buttonLimpiar.FlatStyle = FlatStyle.Flat;
            buttonLimpiar.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            buttonLimpiar.ForeColor = Color.White;
            buttonLimpiar.Location = new Point(359, 365);
            buttonLimpiar.Margin = new Padding(3, 4, 3, 4);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(110, 31);
            buttonLimpiar.TabIndex = 18;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = false;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // lblrepiteContraseña
            // 
            lblrepiteContraseña.AutoSize = true;
            lblrepiteContraseña.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblrepiteContraseña.ForeColor = Color.FromArgb(245, 109, 95);
            lblrepiteContraseña.Location = new Point(359, 95);
            lblrepiteContraseña.Name = "lblrepiteContraseña";
            lblrepiteContraseña.Size = new Size(151, 20);
            lblrepiteContraseña.TabIndex = 19;
            lblrepiteContraseña.Text = "Repite la contraseña";
            // 
            // tbRepitecontraseña
            // 
            tbRepitecontraseña.BorderStyle = BorderStyle.FixedSingle;
            tbRepitecontraseña.Location = new Point(359, 121);
            tbRepitecontraseña.Margin = new Padding(3, 4, 3, 4);
            tbRepitecontraseña.Name = "tbRepitecontraseña";
            tbRepitecontraseña.Size = new Size(179, 27);
            tbRepitecontraseña.TabIndex = 20;
            tbRepitecontraseña.UseSystemPasswordChar = true;
            // 
            // CrearUsuario
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.FromArgb(253, 238, 228);
            ClientSize = new Size(662, 476);
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
            Margin = new Padding(3, 4, 3, 4);
            Name = "CrearUsuario";
            Text = "Crear Usuarios";
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