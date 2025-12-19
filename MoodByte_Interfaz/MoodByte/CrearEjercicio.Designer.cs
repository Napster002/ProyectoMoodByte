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
            ((System.ComponentModel.ISupportInitialize)epEjercicio).BeginInit();
            SuspendLayout();
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Location = new Point(230, 39);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(45, 15);
            lblEstado.TabIndex = 0;
            lblEstado.Text = "Estado:";
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Location = new Point(230, 190);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(40, 15);
            lblTitulo.TabIndex = 1;
            lblTitulo.Text = "Titulo:";
            // 
            // lblDescripcion
            // 
            lblDescripcion.AutoSize = true;
            lblDescripcion.Location = new Point(199, 261);
            lblDescripcion.Name = "lblDescripcion";
            lblDescripcion.Size = new Size(72, 15);
            lblDescripcion.TabIndex = 2;
            lblDescripcion.Text = "Descripcion:";
            // 
            // lblDuracion
            // 
            lblDuracion.AutoSize = true;
            lblDuracion.Location = new Point(213, 116);
            lblDuracion.Name = "lblDuracion";
            lblDuracion.Size = new Size(58, 15);
            lblDuracion.TabIndex = 3;
            lblDuracion.Text = "Duracion:";
            // 
            // cmbEstado
            // 
            cmbEstado.FormattingEnabled = true;
            cmbEstado.Location = new Point(300, 38);
            cmbEstado.Name = "cmbEstado";
            cmbEstado.Size = new Size(121, 23);
            cmbEstado.TabIndex = 4;
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(300, 190);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(168, 23);
            txtTitulo.TabIndex = 5;
            // 
            // txtDescripcion
            // 
            txtDescripcion.Location = new Point(300, 261);
            txtDescripcion.Multiline = true;
            txtDescripcion.Name = "txtDescripcion";
            txtDescripcion.Size = new Size(281, 106);
            txtDescripcion.TabIndex = 6;
            // 
            // btnGuardar
            // 
            btnGuardar.Location = new Point(506, 391);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(75, 23);
            btnGuardar.TabIndex = 8;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = true;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.Location = new Point(346, 391);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(75, 23);
            buttonLimpiar.TabIndex = 9;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = true;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // dtpDuracion
            // 
            dtpDuracion.Format = DateTimePickerFormat.Time;
            dtpDuracion.Location = new Point(300, 110);
            dtpDuracion.Name = "dtpDuracion";
            dtpDuracion.Size = new Size(216, 23);
            dtpDuracion.TabIndex = 10;
            // 
            // epEjercicio
            // 
            epEjercicio.ContainerControl = this;
            // 
            // CrearEjercicio
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
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
            Name = "CrearEjercicio";
            Text = "CrearEjercicio";
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
    }
}