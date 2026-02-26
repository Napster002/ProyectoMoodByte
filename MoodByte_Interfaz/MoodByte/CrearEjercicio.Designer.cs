namespace MoodByte
{
    partial class CrearEjercicio
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
            lblEstado = new Label();
            lblTitulo = new Label();
            lblDescripcion = new Label();
            lblDuracion = new Label();
            cmbEstado = new ComboBox();
            txtTitulo = new TextBox();
            txtDescripcion = new TextBox();
            btnGuardar = new Button();
            buttonLimpiar = new Button();
            dtpDuracion = new DateTimePicker();
            epEjercicio = new ErrorProvider(components);
            lblUrl = new Label();
            txtUrl = new TextBox();
            ((System.ComponentModel.ISupportInitialize)epEjercicio).BeginInit();
            SuspendLayout();
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblEstado.ForeColor = Color.FromArgb(245, 109, 95);
            lblEstado.Location = new Point(217, 51);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(56, 20);
            lblEstado.TabIndex = 0;
            lblEstado.Text = "Estado";
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblTitulo.ForeColor = Color.FromArgb(245, 109, 95);
            lblTitulo.Location = new Point(224, 196);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(50, 20);
            lblTitulo.TabIndex = 1;
            lblTitulo.Text = "Titulo";
            // 
            // lblDescripcion
            // 
            lblDescripcion.AutoSize = true;
            lblDescripcion.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblDescripcion.ForeColor = Color.FromArgb(245, 109, 95);
            lblDescripcion.Location = new Point(184, 340);
            lblDescripcion.Name = "lblDescripcion";
            lblDescripcion.Size = new Size(90, 20);
            lblDescripcion.TabIndex = 2;
            lblDescripcion.Text = "Descripcion";
            // 
            // lblDuracion
            // 
            lblDuracion.AutoSize = true;
            lblDuracion.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblDuracion.ForeColor = Color.FromArgb(245, 109, 95);
            lblDuracion.Location = new Point(202, 124);
            lblDuracion.Name = "lblDuracion";
            lblDuracion.Size = new Size(72, 20);
            lblDuracion.TabIndex = 3;
            lblDuracion.Text = "Duracion";
            // 
            // cmbEstado
            // 
            cmbEstado.FormattingEnabled = true;
            cmbEstado.Location = new Point(296, 51);
            cmbEstado.Margin = new Padding(3, 4, 3, 4);
            cmbEstado.Name = "cmbEstado";
            cmbEstado.Size = new Size(141, 28);
            cmbEstado.TabIndex = 4;
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(296, 196);
            txtTitulo.Margin = new Padding(3, 4, 3, 4);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(321, 27);
            txtTitulo.TabIndex = 5;
            // 
            // txtDescripcion
            // 
            txtDescripcion.Location = new Point(296, 340);
            txtDescripcion.Margin = new Padding(3, 4, 3, 4);
            txtDescripcion.Multiline = true;
            txtDescripcion.Name = "txtDescripcion";
            txtDescripcion.Size = new Size(321, 140);
            txtDescripcion.TabIndex = 6;
            // 
            // btnGuardar
            // 
            btnGuardar.BackColor = Color.FromArgb(252, 144, 139);
            btnGuardar.FlatAppearance.BorderSize = 0;
            btnGuardar.FlatStyle = FlatStyle.Flat;
            btnGuardar.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnGuardar.ForeColor = Color.White;
            btnGuardar.Location = new Point(489, 521);
            btnGuardar.Margin = new Padding(3, 4, 3, 4);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(130, 31);
            btnGuardar.TabIndex = 8;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = false;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.BackColor = Color.FromArgb(252, 144, 139);
            buttonLimpiar.FlatAppearance.BorderColor = Color.Salmon;
            buttonLimpiar.FlatAppearance.BorderSize = 0;
            buttonLimpiar.FlatStyle = FlatStyle.Flat;
            buttonLimpiar.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            buttonLimpiar.ForeColor = Color.White;
            buttonLimpiar.Location = new Point(296, 521);
            buttonLimpiar.Margin = new Padding(3, 4, 3, 4);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(130, 31);
            buttonLimpiar.TabIndex = 9;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = false;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // dtpDuracion
            // 
            dtpDuracion.Format = DateTimePickerFormat.Time;
            dtpDuracion.Location = new Point(296, 124);
            dtpDuracion.Margin = new Padding(3, 4, 3, 4);
            dtpDuracion.Name = "dtpDuracion";
            dtpDuracion.Size = new Size(141, 27);
            dtpDuracion.TabIndex = 10;
            // 
            // epEjercicio
            // 
            epEjercicio.ContainerControl = this;
            // 
            // lblUrl
            // 
            lblUrl.AutoSize = true;
            lblUrl.Font = new Font("Segoe UI", 9F, FontStyle.Bold);
            lblUrl.ForeColor = Color.FromArgb(245, 109, 95);
            lblUrl.Location = new Point(236, 268);
            lblUrl.Name = "lblUrl";
            lblUrl.Size = new Size(38, 20);
            lblUrl.TabIndex = 11;
            lblUrl.Text = "URL";
            // 
            // txtUrl
            // 
            txtUrl.Location = new Point(296, 268);
            txtUrl.Name = "txtUrl";
            txtUrl.Size = new Size(321, 27);
            txtUrl.TabIndex = 12;
            // 
            // CrearEjercicio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.FromArgb(253, 238, 228);
            ClientSize = new Size(914, 600);
            Controls.Add(txtUrl);
            Controls.Add(lblUrl);
            Controls.Add(dtpDuracion);
            Controls.Add(buttonLimpiar);
            Controls.Add(btnGuardar);
            Controls.Add(txtDescripcion);
            Controls.Add(txtTitulo);
            Controls.Add(cmbEstado);
            Controls.Add(lblDuracion);
            Controls.Add(lblDescripcion);
            Controls.Add(lblTitulo);
            Controls.Add(lblEstado);
            Margin = new Padding(3, 4, 3, 4);
            Name = "CrearEjercicio";
            Text = "Crear Ejercicios";
            Load += CrearEjercicio_Load;
            ((System.ComponentModel.ISupportInitialize)epEjercicio).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblEstado;
        private Label lblTitulo;
        private Label lblDescripcion;
        private Label lblDuracion;
        private ComboBox cmbEstado;
        private TextBox txtTitulo;
        private TextBox txtDescripcion;
        private Button btnGuardar;
        private Button buttonLimpiar;
        private DateTimePicker dtpDuracion;
        private ErrorProvider epEjercicio;
        private TextBox txtUrl;
        private Label lblUrl;
    }
}